from flask import Flask, render_template, request


app = Flask(__name__)
@app.route("/", methods=['GET', 'POST'])

def index():
    if request.method == 'POST':
        if request.form.get('action1') == 'VALUE1':
            return "B 1"
        elif  request.form.get('action2') == 'VALUE2':
            return "B 2"
        else:
            return "b 3"
    elif request.method == 'GET':
        return render_template('home.html')
    
    return render_template("home.html")

if __name__ == "__main__":
    app.run(debug=True)
