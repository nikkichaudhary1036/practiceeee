<!DOCTYPE html>
<html>
<head>
    <title>To Do List</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
            text-align: center;
            margin-top: 100px;
        }
        .box {
            background: white;
            width: 300px;
            margin: auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }
        input {
            width: 70%;
            padding: 8px;
        }
        button {
            padding: 8px 10px;
            background: green;
            color: white;
            border: none;
            cursor: pointer;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            background: #ddd;
            margin: 5px;
            padding: 8px;
            border-radius: 5px;
        }
        span {
            color: red;
            float: right;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="box">
    <h2>My To-Do List</h2>
    <input type="text" id="task" placeholder="Enter task">
    <button onclick="addTask()">Add</button>

    <ul id="list"></ul>
</div>

<script>
    function addTask() {
        let task = document.getElementById("task").value;

        if(task === "") {
            alert("Please enter a task");
            return;
        }

        let li = document.createElement("li");
        li.innerHTML = task + "<span onclick='this.parentElement.remove()'>❌</span>";

        document.getElementById("list").appendChild(li);
        document.getElementById("task").value = "";
    }
</script>

</body>
</html>
