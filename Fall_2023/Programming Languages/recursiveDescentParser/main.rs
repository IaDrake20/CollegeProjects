#![allow(non_snake_case)]

mod parser_descent;
mod parser_pratt;
mod token;
mod lexer_mockup;
mod lexer;
mod parse_tree;

fn main() {
    parser_descent::main();
    //parser_pratt::main();
}
