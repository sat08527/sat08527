from flask import Flask, request, jsonify

app = Flask(__name__)

# A simple dictionary to store chat history
chat_history = []

@app.route('/chat', methods=['POST'])
def chat():
    # Get the incoming message from the request
    incoming_message = request.json['message']

    # Store the incoming message in the chat history
    chat_history.append({'user': 'user', 'message': incoming_message})

    # Process the message (You can add your own logic here)
    response_message = process_message(incoming_message)

    # Store the response message in the chat history
    chat_history.append({'user': 'bot', 'message': response_message})

    # Return the response to the user
    return jsonify({'message': response_message})

def process_message(message):
    # This is a simple echo bot, which echoes back the received message
    return message

@app.route('/chat/history', methods=['GET'])
def get_chat_history():
    return jsonify(chat_history)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
