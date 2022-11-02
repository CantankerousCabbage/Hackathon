# Import the module
import json

# String with JSON format
with open('Matt/test_matt2.json', 'r') as f:
    data = json.load(f)

    # Convert JSON string to dictionary
    #data_dict = json.load(data)

# print(data)
# print(type(data))

print(data.keys())
print(data.values())


for key in data.keys():
    print(key)

    for value in data[key]:
        print(value)
    