from copy import deepcopy
import pandas
import json


def cross_join(left, right):
    new_rows = [] if right else left
    for left_row in left:
        for right_row in right:
            temp_row = deepcopy(left_row)
            for key, value in right_row.items():
                temp_row[key] = value
            new_rows.append(deepcopy(temp_row))
    return new_rows


def flatten_list(data):
    for elem in data:
        if isinstance(elem, list):
            yield from flatten_list(elem)
        else:
            yield elem


def json_to_dataframe(data_in):
    def flatten_json(data, prev_heading=''):
        if isinstance(data, dict):
            rows = [{}]
            for key, value in data.items():
                rows = cross_join(rows, flatten_json(value, prev_heading + '_' + key))
        elif isinstance(data, list):
            rows = []
            for item in data:
                [rows.append(elem) for elem in flatten_list(flatten_json(item, prev_heading))]
        else:
            rows = [{prev_heading[1:]: data}]
        return rows

    return pandas.DataFrame(flatten_json(data_in))


def search(key, value, json_file):
    """
    Function that will  search in json file

    Args:
        key: key to search
        value: value to search
        json_file: the file to search

    Returns:

    """
    with open(json_file, 'r') as file:
        data = json.load(file)
        for item in data:
            if item[key] == value:
                return True
        return False

if __name__ == '__main__':

    with open('AutoClave5 JSON Files\AC2-07337-anon.json', 'r') as f:
        data = json.load(f)
        df = json_to_dataframe(data)
        print(df)

        #output to csv
        df.to_csv('output1.csv', index=False)



