import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThymeleafVariableExtractor {

    public static void main(String[] args) {
        String template = "<html><body><h1 th:text=\"${title}\" th:if=\"${condition}\"></h1></body></html>";
        Set<String> variables = extractVariablesFromTemplate(template);
        System.out.println("Variables: " + variables);
    }

    public static Set<String> extractVariablesFromTemplate(String template) {
        Set<String> variables = new HashSet<>();

        Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            variables.add(matcher.group(1));
        }

        pattern = Pattern.compile("#\\{(.*?)\\}");
        matcher = pattern.matcher(template);
        while (matcher.find()) {
            variables.add(matcher.group(1));
        }

        pattern = Pattern.compile("@\\{(.*?)\\}");
        matcher = pattern.matcher(template);
        while (matcher.find()) {
            variables.add(matcher.group(1));
        }

        pattern = Pattern.compile("~\\{(.*?)\\}");
        matcher = pattern.matcher(template);
        while (matcher.find()) {
            variables.add(matcher.group(1));
        }

        pattern = Pattern.compile("\\*\\{(.*?)\\}");
        matcher = pattern.matcher(template);
        while (matcher.find()) {
            variables.add(matcher.group(1));
        }

        pattern = Pattern.compile("th:([a-zA-Z]+)=\"\\$\\{(.*?)\\}\"");
        matcher = pattern.matcher(template);
        while (matcher.find()) {
            variables.add(matcher.group(2));
        }

        return variables;
    }
}
