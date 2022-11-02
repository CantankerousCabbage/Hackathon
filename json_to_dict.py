# Import the module
import json
import collections.abc
import pandas as pd

# Opens JSON file as a DICT
with open('AutoClave5 JSON Files\AC2-07337-anon.json', 'r') as f:
    data = json.load(f)

with open('AutoClave5 JSON Files\AC2-07337-anon.json', 'r') as f:
    data = json.load(f)

#JSON are loaded as a DICT in python 3.11
print(type(data))

#Create a DICT search query
# for key in data.keys():
#     print("the key is {} and the value is {}".format(key, data[key]))


#Function to flatten the dictionary
# def flatten(d, parent_key='', sep='_'):
#     items = []
#     for k, v in d.items():
#         new_key = parent_key + sep + k if parent_key else k
#         if isinstance(v, collections.abc.MutableMapping):
#             items.extend(flatten(v, new_key, sep=sep).items())
#         else:
#             items.append((new_key, v))
#     return dict(items)

# flattenedDict = flatten(data)
# print(flattenedDict)

flatDictionary = pd.json_normalize(data)
print(flatDictionary)