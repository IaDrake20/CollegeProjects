#![allow(non_camel_case_types)]
#![allow(dead_code)]

use std::fmt;
use std::mem::discriminant;
use std::fmt::{Display, Formatter};



#[derive(Debug, Clone)]
pub enum Token {

    PARENS_L, PARENS_R, BRACKET_L, BRACKET_R, BRACE_L, BRACE_R,
    POINT, COMMA, COLON, SEMICOLON, ARROW_R,
    ADD, SUB, MUL, DIV,
    EQ, LT, GT, NEQ, NLT, NGT,
    NOT, AND, OR,
    ASSIGN,
    FUNC, LET, IF, ELSE, WHILE, PRINT,
    ID(String),
    TYPE_INT32(i32), BT_LIT_FLT32(f32), TYPE_CHAR(char),
    LIT_INT32(i32), LIT_FLT32(f32), LIT_CHAR(char), LIT_STRING(String),
    EOI
}

impl fmt::Display for Token {
    fn fmt(&self, f: &mut Formatter<'_>) -> fmt::Result {

    }
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