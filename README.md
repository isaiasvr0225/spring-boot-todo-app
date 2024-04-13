
# Spring boot Todo app 

This is a simple Todo application built using Spring Boot. It allows users to create, update, delete, and view todo tasks. The project is structured to follow best practices in Spring Boot development.

Prerequisites
Before you begin, ensure you have met the following requirements:

Java Development Kit (JDK) 17 or later installed on your machine.
Maven installed on your machine.
An IDE such as IntelliJ IDEA or Eclipse for development (optional but recommended).


## API Reference


```http
  GET /api/v1/tasks
```

| Query Params | Return Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page` `size`| `Page<TaskDto>` | Return all tasks with pagination. |


```http
  GET /api/v1/tasks{id}
```

| Path Param | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `TaskDto` | Return a task with the specific **id** 

```http
  POST /api/v1/tasks
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `none`      | `TaskDto` |  Save a new task and return it.|

```http
  PUT /api/v1/tasks{id}
```

| Path Param | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `TaskDto` |  Find a task with the specific **id** and update it.|

```http
  DELETE /api/v1/tasks{id}
```

| Path Param | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `TaskDto` |  Find a task with the specific **id** and delete it.|

Getting Started with Docker
To get started with the project using Docker, follow these steps:

Clone this repository to your local machine:
```bash
  git clone https://github.com/yourusername/todo-spring-boot.git
```

Navigate to the project directory:
```bash
  cd todo-spring-boot
```

Build the Docker image:
```bash
  docker build -t todo-spring-boot
```

Run the Docker container:
```bash
  docker run -p 8080:8080 todo-spring-boot
```

The application will start inside a Docker container and will be accessible at http://localhost:8080.
