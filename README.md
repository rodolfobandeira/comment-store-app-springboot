# Sample Microservice using SpringBoot. 

```
Basic Auth:

Username: admin
Password: password
```

---


`/create` POST

Body:
```
comment: 'foo'
pageId: 'abc123'
emailAddress: example@example.org
username: rodolfo
```

---

`/list/{id}` GET

```
  {
    "id": "ac8682c3-79d3-47f6-a6c5-5c5869c00ea7",
    "username": "rodolfo",
    "emailAddress": "foo@example.org",
    "comment": "Hi test comment One!!",
    "created": 1492657983209
  }
```
---

`/listall` GET

```
[
  {
    "id": "ac8682c3-79d3-47f6-a6c5-5c5869c00ea7",
    "username": "rodolfo",
    "emailAddress": "foo@example.org",
    "comment": "Hi test comment One!!",
    "created": 1492657983209
  },
  {
    "id": "3243ac76-d47c-4886-8494-967137fb44d7",
    "username": "rodolfo",
    "emailAddress": "foo@example.org",
    "comment": "Hi test comment One!!",
    "created": 1492657989762
  }
]
```
