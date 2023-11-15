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

impl fmt::Display for Token {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            Token::PARENS_L => write!(f, "("),
            Token::PARENS_R => write!(f, ")"),
            Token::BRACE_L => write!(f, "["),
            Token::BRACE_R => write!(f, "}}"),
            Token::BRACKET_L => write!(f, "{{"),
            Token::BRACKET_R => write!(f, "}}"),
            Token::POINT => write!(f, "."),
            Token::COMMA => write!(f, ","),
            Token::COLON => write!(f, ":"),
            Token::SEMICOLON => write!(f, ";"),
            Token::ARROW_R => write!(f, "=>"),
            Token::ADD => write!(f, "+"),
            Token::SUB => write!(f, "-"),
            Token::MUL => write!(f, "*"),
            Token::DIV => write!(f, "/"),
            Token::EQ => write!(f, "=="),
            Token::NEQ => write!(f, "!="),
            Token::LT => write!(f, "<"),
            Token::GT => write!(f, ">"),
            Token::NLT => write!(f, "!<"),
            Token::NGT => write!(f, "!>"),
            Token::NOT => write!(f, "!"),
            Token::AND => write!(f, "&&"),
            Token::OR => write!(f, "||"),
            Token::ASSIGN => write!(f, "="),
            Token::FUNC => write!(f, "FUNC"),
            Token::LET => write!(f, "LET"),
            Token::IF => write!(f, "IF"),
            Token::ELSE => write!(f, "ELSE"),
            Token::WHILE => write!(f, "WHILE"),
            Token::PRINT => write!(f, "PRINT"),
            _ => {
                Ok(())
            }
        }
    }
}
