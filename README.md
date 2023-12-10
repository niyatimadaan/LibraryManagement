# Library CRUD API

## Usage

This project uses MongoDB. Add the MongoDB URI in `application.properties` before starting the app.

To run the web application with Maven:
```
./mvnw spring-boot:run
```

To seed the database:
```
./mvnw spring-boot:run "-Dspring-boot.run.arguments=seed <count>"
```

## API

Book Object has 4 attributes:
- ID: Server generated ID (String)
- Name: Name of the book (String)
- Author: Author of the book (String)
- Sales: Sold copies of the book (Long)

#### GET &nbsp; /api/books

Returns a list of all book items.

Response:
```json
[
  {
    "id": "...",
    "name": "...",
    "author": "...",
    "sales": 0
  },
  ...
]
```

#### POST &nbsp; /api/books

Inserts a new Book with the request details.

Request Body:
```json
{
  "name": "...",
  "author": "...",
  "sales": 0
}
```

Response:
```json
{
  "id": "...",
  "name": "...",
  "author": "...",
  "sales": 0
}
```

If the name and author pair already exists it returns an error:
```json
{
  "status": 400,
  "errors": ["A book with the similar ID or name and author already exists."]
}
```
Similar errors are given for invalid request payloads.

#### PUT &nbsp; /api/books/{id}

Updates the Book with `id` with the requested details.

Request Body:
```json
{
  "name": "...",
  "author": "...",
  "sales": 0
}
```

Response:
```json
{
  "id": "...",
  "name": "...",
  "author": "...",
  "sales": 0
}
```

Errors similar to previous endpoint are thrown.