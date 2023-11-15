#![allow(non_camel_case_types)]
#![allow(dead_code)]

use std::fmt;
use std::mem::discriminant;



#[derive(Debug, Clone)]
pub enum Token {

    PARENS_L, PARENS_R, BRACKET_L, BRACKET_R, BRACE_L, BRACE_R,
    POINT, COMMA, COLON, SEMICOLON, ARROW_R,
    ADD, SUB, MUL, DIV,
    EQ, LT, GT, NEQ, NLT, NGT,
    NOT, AND, OR,
    ASSIGN,
    FUNC, LET, IF, ELSE, WHILE, PRINT,
    ID(String), TYPE_ID,
    TYPE_INT32(), BT_FLT32(), TYPE_CHAR(),
    LIT_INT32(i32), LIT_FLT32(f32), LIT_CHAR(char), LIT_STRING(String),
    EOI
}

impl PartialEq for Token {
    fn eq(&self, other: &Self) -> bool {
        discriminant(self) == discriminant(other)
    }
}

impl Eq for Token { }

impl Token {
    pub fn id() -> Token {
        Token::ID(String::new())
    }
    pub fn lit_i32() -> Token { Token::LIT_INT32(0) }
}