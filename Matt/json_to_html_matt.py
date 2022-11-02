# pip install json2html

from json2html import *
import json

jsonList = [
"AutoClave5 JSON Files\AC2-07337-anon.json",
"AutoClave5 JSON Files\AC2-07338-anon.json",
"AutoClave5 JSON Files\AC2-07339-anon.json",
"AutoClave5 JSON Files\AC2-07340-anon.json",
"AutoClave5 JSON Files\AC2-07341-anon.json",
"AutoClave5 JSON Files\AC2-07343-anon.json",
"AutoClave5 JSON Files\AC2-07347-anon.json",
"AutoClave5 JSON Files\AC2-07351-anon.json",
"AutoClave5 JSON Files\AC2-07354-anon.json",
"AutoClave5 JSON Files\AC2-07356-anon.json",
"AutoClave5 JSON Files\AC3-06994-anon.json",
"AutoClave5 JSON Files\AC3-07001-anon.json",
"AutoClave5 JSON Files\AC3-06998-anon.json",
"AutoClave5 JSON Files\AC3-07003-anon.json",
"AutoClave5 JSON Files\AC3-07005-anon.json",
"AutoClave5 JSON Files\AC3-07007-anon.json",
"AutoClave5 JSON Files\AC4-02979-anon.json",
"AutoClave5 JSON Files\AC4-02980-anon.json",
"AutoClave5 JSON Files\AC4-02983-anon.json",
"AutoClave5 JSON Files\AC4-02988-anon.json"]

for jsonFile in jsonList:
        with open(jsonFile) as json_data:
                d = json.load(json_data)
                html = json2html.convert(json = d)
                htmlFile = jsonFile.replace("json", "html")
                with open(htmlFile, "w") as text_file:
                        text_file.write(html)
# with open('AutoClave5 JSON Files\AC2-07337-anon.json') as json_file:
#     input = json.load(json_file)


# input = {
#         "name": "json2html",
#         "description": "Converts JSON to HTML tabular representation"
# }

# output = json2html.convert(json = input)

# print(output)
# print(type(output))
# #save output as html file

# with open("output.html", "w") as f:
#     f.write(output)