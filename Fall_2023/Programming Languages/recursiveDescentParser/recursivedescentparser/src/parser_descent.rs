#![allow(non_camel_case_types)]
#![allow(non_snake_case)]

//use crate::lexer_mockup::Lexer;
use crate::lexer::Lexer;
use crate::token::Token;

const INDENT : usize = 2;


pub fn main() {

    // create recursive descent parser
    let mut lexer = Lexer::new(Vec::new(), "FUNC (ADD (a:i32 , b:i32) => i32 [[[][]][]] \n FUNC ())".to_string());
    let mut parser = DescentParser::new(lexer.clone());
    lexer.advance();
    parser = DescentParser::new(lexer.clone());

    // start recursive descent parsing
    parser.analyze();

}


#[derive(Debug)]
struct DescentParser {
    lexer: Lexer,
    indent: usize,
}


impl DescentParser {  // simple recursive descend parser

    fn new(lexer: Lexer) -> DescentParser {
        DescentParser {
            lexer,
            indent: 0,
        }
    }

    pub fn analyze(&mut self) {
        self.indent = 0;
        self.parse_func();
        self.expect(Token::EOI);
    }

    fn parse_func(&mut self) {
        self.indent_print("parse_func()");
        self.indent_increment();
        {
            self.expect(Token::FUNC);
            self.expect(Token::id());
            self.parse_parameter_list();
            self.expect(Token::ARROW_R);
            self.expect(Token::id());
            self.parse_block_nest();
        }
        self.indent_decrement();
    }

    fn parse_parameter_list(&mut self) {
        self.indent_print("parse_parameter_list()");
        self.indent_increment();
        {
            self.expect(Token::PARENS_L);
            if self.accept(Token::PARENS_R) {
                return;
            }
            self.parse_parameter();
            while self.accept(Token::COMMA) {
                self.parse_parameter();
            }
            self.expect(Token::PARENS_R);
        }
        self.indent_decrement();
    }

    fn parse_parameter(&mut self) {
        self.indent_print("parse_parameter()");
        self.indent_increment();
        {
            self.expect(Token::id());
            self.expect(Token::COLON);
            self.parse_type();
        }
        self.indent_decrement();
    }

    fn parse_block_nest(&mut self) {
        self.indent_print("parse_block_nest()");
        self.indent_increment();
        {
            self.expect(Token::BRACKET_L);
            if self.peek(Token::BRACKET_L) {
                self.parse_block_list();
            }
            self.expect(Token::BRACKET_R);
        }
        self.indent_decrement();
    }

    fn parse_block_list(&mut self) {
        println!("{:?} in parse block list", self);
        self.indent_print("parse_block_list()");
        self.indent_increment();
        {
            self.parse_block_nest();
            if self.peek(Token::BRACKET_L) {
                self.parse_block_list()
            }
        }
        self.indent_decrement();
    }

    fn parse_type(&mut self){
        println!("{:?} in parse type", self);
        self.indent_print("parse type");
        self.indent_increment();
        {
            match self.lexer.curr() {
                Token::TYPE_INT32() => {
                    self.expect(Token::TYPE_INT32());
                }
                Token::TYPE_CHAR() => {
                    self.expect(Token::TYPE_CHAR());
                }
                _ => {
                    panic!("Unknown token in parse type");
                }
            }
        }
    }
}


impl DescentParser { // utility functions for lexer

    fn curr(&mut self) -> Token {
        self.lexer.curr()
    }

    fn advance(&mut self) {
        println!("lexer advancing");
        self.lexer.advance();
        println!("Lexer Advanced");
    }

    fn expect(&mut self, symbol: Token) {
        println!("\n {:?} in expect", self);
        println!("{:?} is current token", self.curr());
        println!("{:?} is current symbol", symbol);
        if self.curr() == symbol {
            self.advance();
            println!("{:<indent$}expect({symbol:?})", "", indent = self.indent);
        } else {
            panic!("Did not expect '{symbol:?}'!");
        }
    }

    fn accept(&mut self, symbol: Token) -> bool {
        println!("{:?} in accept", self);
        if self.curr() == symbol {
            self.advance();
            true
        } else {
            false
        }
    }

    fn peek(&mut self, symbol: Token) -> bool {
        self.lexer.curr() == symbol
    }

}


impl DescentParser { // utility functions for pretty print

    fn indent_print(&mut self, msg: &'static str) {
        println!("{:<indent$}{:}", "", msg, indent=self.indent);
    }

    fn indent_increment(&mut self) {
        self.indent += INDENT;
    }
    fn indent_decrement(&mut self) {
        self.indent -= INDENT;
    }

}
