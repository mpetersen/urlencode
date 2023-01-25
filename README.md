# urlencode

A simple command line script to URL encode text input.

## Installation

Compile and install the run script to `/usr/local/bin`:

    make


## Usage

This tool can be used in three different ways:

### Command line arguments

    $ urlencode Hello World "Hello, World"
    Hello
    World
    Hello%2C+World

This will print one line per encoded argument.

### Console input

If no command line arguments are provided, then one line is read from console, without a prompt:

    $ urlencode
    Hello, World
    Hello%2C+World

This will print the encoded value.

### Clipboard

If there are no command line arguments, and the console input is not available, the input is read from the system clipboard, e.g.:

    $ urlencode | pbcopy

This will read the input from clipboard, and `pbcopy` will copy the output to the clipboard again (macOS only).

### Decoding

In order to decode an already encoded string, use the command line argument `-d`:

    $ urlencode -d Hello%2C+World
    Hello, World