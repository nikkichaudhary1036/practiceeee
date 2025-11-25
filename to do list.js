<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>To-Do List App</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f3f3;
            padding: 40px;
        }
        .container {
            width: 350px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
        }
        input {
            width: 70%;
            padding: 8px;
        }
        button {
            padding: 8px 10px;
            cursor: pointer;
        }
        ul {
            margin-top: 20px;
            padding: 0;
        }
        li {
            list-style: none;
            background: #eaeaea;
            padding: 10px;
            margin: 5px 0;
            display: flex;
            justify-content: space-between;
            border-radius: 5px;
        }
        .completed {
            text-decoration: line-through;
            background: #c5ffc5;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>To-Do List</h2>

        <input id="taskInput" type="text" placeholder="Enter task">
        <button onclick="addTask()">Add</button>

        <ul id="taskList"></ul>
    </div>


    <script>
        function addTask() {
            let taskText = document.getElementById("taskInput").value;

            if (taskText === "") {
                alert("Please enter a task");
                return;
            }

            let li = document.createElement("li");

            li.innerHTML = `
                <span onclick="toggleComplete(this)">${taskText}</span>
                <button onclick="deleteTask(this)">Delete</button>
            `;

            document.getElementById("taskList").appendChild(li);
            document.getElementById("taskInput").value = "";
        }

        function deleteTask(button) {
            button.parentElement.remove();
        }

        function toggleComplete(task) {
            task.parentElement.classList.toggle("completed");
        }
    </script>

</body>
</html>
