# Import the module
import json

# String with JSON format
with open('Matt/test_matt2.json', 'r') as f:
    data = json.load(f)

    # Convert JSON string to dictionary
    #data_dict = json.load(data)

print(data)
