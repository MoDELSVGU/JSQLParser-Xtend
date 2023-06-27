# JSQLParser-Xtend
An extension of JSQLParser library that parses SQL string to Java object hierarchy.

```
<dependency>
  <groupId>io.github.modelsvgu</groupId>
  <artifactId>sqlj</artifactId>
  <version>[1.0.0,)</version>
</dependency>
```

### What's extended?
- CompoundStatement (i.e., [MySQL](https://dev.mysql.com/doc/refman/8.0/en/sql-compound-statements.html)).
- StoredProcedure (CREATE, DROP).
- Triggers (CREATE, DROP).
- Function (CREATE, DROP).
- Constraints (e.g., NOTNULL, UNIQUE, PRIMARY_KEY, CHECK, DEFAULT).
