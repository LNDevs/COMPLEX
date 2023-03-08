# Code Documentation

## Example Code Explanation

```
~PRAGMA COMPLEX 00
00 WRITE >> CONSOLE "Hello World"
10 END
```

### `~PRAGMA COMPLEX 00`

Sets the level of syntax needed by the application, and allows it to run in realtime. The `~` symbol denotes a preprocessor directive.

### `00 WRITE >> CONSOLE "Hello World"`

- `00` is a line number, as in the BASIC programming language.
- `WRITE` is a command that writes output to an output stream.
- `>>` is a "ROUTE" operator that specifies where to write the output. In this case, `CONSOLE` is specified.
- `"Hello World"` is the content that will be written to the console.

### `10 END`

- `10` is another line number.
- `END` marks the end of the program.

## Data Types

The scripting language supports the following data types:

- Floats
- Ints
- Bools
- Strings

## Additional Information

- To write to a variable, use the `>>>` operator: `WRITE >>> VARNAME "CONTENT"`
- This is a simple example of how the scripting language works, using a line-based syntax with basic commands.
- The `ROUTE` operator allows users to specify where the output should be written.
- The `PRAGMA` command sets the level of complexity needed by the application.
- The available data types are mentioned, but not used in this example.
