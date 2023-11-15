//use crate::LexerState::{ASSIGN_STATE, INITIAL_STATE, OPERATION_STATE};
use crate::token;
use std::any::type_name;
use crate::lexer::LexerState::{ASSIGN_STATE, INITIAL_STATE, OPERATION_STATE};
use crate::token::Token;
use crate::token::Token::EOI;

fn type_of<T>(_: T) -> &'static str {
    type_name::<T>()
}

#[derive(Debug, Clone)]
enum LexerState {
    //lexer states, might add a comparison
    INITIAL_STATE, ASSIGN_STATE, OPERATION_STATE, IDENTIFIER_STATE, NUMBER_STATE, STRING_STATE, CHAR_STATE, END_STATE
}
#[derive(Debug, Clone)]
pub(crate) struct Lexer {
    input_string: String,
    input_position: i32,
    current_state: LexerState,
    current_token: Token,
    token_vector: Vec<Token>,
    buffer: String
}

impl Lexer {
    pub fn new(input: Vec<Token>, str: String) -> Lexer {
        Lexer {
            input_string: str,
            input_position: 0,
            current_state: INITIAL_STATE,
            current_token: Token::EOI,
            token_vector: input,
            buffer: String::new()
        }
    }

    pub fn set_input(&mut self, input: String) {
        self.input_string = input;
    }

    pub fn advance(&mut self) -> Token {
        self.buffer.clear(); // Clear the buffer before reading the next token

        println!("L::::::{:?} is current token", self.current_token);
        println!("L::::::{:?} is current position", self.input_position);

        while self.input_position < self.input_string.len() as i32 {
            //println!("position is {}", self.input_position);
            let ch = self.input_string.chars().nth(self.input_position as usize).unwrap();
            //println!("Currently looking at {}", ch);
            if ch.is_alphabetic() {
                match ch {
                    'F' => {
                        let e1 = self.input_string.chars().nth((self.input_position + 1) as usize);
                        let e2 = self.input_string.chars().nth((self.input_position + 2) as usize);
                        let e3 = self.input_string.chars().nth((self.input_position + 3) as usize);
                        if e1 == Option::from('U') && e2 == Option::from('N') && e3 == Option::from('C') {
                            self.current_token = Token::FUNC;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::FUNC);
                            self.buffer.push('F');
                            self.buffer.push('U');
                            self.buffer.push('N');
                            self.buffer.push('C');
                            self.input_position += 4;
                        }
                    },
                    'A' => {
                        let e1 = self.input_string.chars().nth((self.input_position + 1) as usize);
                        let e2 = self.input_string.chars().nth((self.input_position + 2) as usize);
                        if e1 == Option::from('D') && e2 == Option::from('D') {
                            self.current_token = Token::ADD;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::ADD);
                            self.buffer.push('A');
                            self.buffer.push('D');
                            self.buffer.push('D');
                            self.input_position += 3;
                        }
                    },
                    'i' => {
                        let e1 = self.input_string.chars().nth((self.input_position + 1) as usize);
                        let e2 = self.input_string.chars().nth((self.input_position + 2) as usize);
                        let e3 = self.input_string.chars().nth((self.input_position + 4) as usize);
                        let e4 = self.input_string.chars().nth((self.input_position + 5) as usize);
                        if e1 == Option::from('n') && e2 == Option::from('t' ) && e3 == Option::from('3') && e2 == Option::from('2') {
                            self.current_token = Token::ADD;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::ADD);
                            self.buffer.push('i');
                            self.buffer.push('n');
                            self.buffer.push('t');
                            self.buffer.push('3');
                            self.buffer.push('2');
                            self.input_position += 3;
                        }
                    }
                    _ => {
                        self.current_token = Token::ID(ch.to_string());
                        self.current_state = LexerState::ASSIGN_STATE;

                    }
                }
            } else if ch.is_numeric() {
                match type_of(ch) {
                    i32=> {
                        self.current_token = Token::TYPE_INT32();
                    },
                    f32 => {
                        self.current_token = Token::BT_FLT32();
                    }
                }
                self.current_token = Token::ID(" ".to_string());
            } else if ch.is_whitespace(){
                self.current_token = Token::ID(" ".to_string());
                //self.input_position += 1;
            } else {
                match ch {
                    '=' => {
                        if self.input_string.chars().nth((self.input_position + 1) as usize) == Option::from('=') {
                            self.current_token = Token::EQ;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::EQ);
                            self.buffer.push('=');
                            self.buffer.push('=');
                            self.input_position += 2;
                        } else if self.input_string.chars().nth((self.input_position + 1) as usize) == Option::from('>'){
                            self.current_token = Token::ARROW_R;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::ARROW_R);
                            self.buffer.push('+');
                            self.buffer.push('>');
                            self.input_position += 1;
                        }else {
                            self.current_token = Token::ASSIGN;
                            self.current_state = ASSIGN_STATE;
                            self.token_vector.push(Token::ASSIGN);
                            self.buffer.push('=');
                            self.input_position += 1;
                        }
                    },
                    '<' => {
                        if self.input_string.chars().nth((self.input_position + 1) as usize) == Option::from('=') {
                            self.current_token = Token:: NGT;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::NGT);
                            self.input_position += 2;
                            self.buffer.push('<');
                            self.buffer.push('=');
                        } else {
                            self.current_token = Token::LT;
                            self.current_state = OPERATION_STATE;
                            self.token_vector.push(Token::LT);
                            self.buffer.push('<');
                            self.input_position += 1;
                        }
                    },
                    '>' => {
                        if self.input_string.chars().nth((self.input_position + 1) as usize) == Option::from('=') {
                            self.current_token = Token:: NLT;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::NLT);
                            self.buffer.push('>');
                            self.buffer.push('=');
                            self.input_position += 2;
                        } else {
                            self.current_token = Token::GT;
                            self.current_state = OPERATION_STATE;
                            self.token_vector.push(Token::GT);
                            self.buffer.push('>');
                            self.input_position += 1;
                        }
                    },
                    '+' => {
                        self.current_token = Token::ADD;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::ADD);
                        self.input_position += 1;
                    },
                    '-' => {
                        let my_char = self.input_string.chars().nth((self.input_position + 1) as usize).unwrap_or_default();
                        if my_char.is_numeric() {
                            //is subtraction
                            self.current_token = Token::SUB;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::SUB);
                            self.input_position += 1;
                        }
                    },
                    '*' => {
                        self.current_token = Token::MUL;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::MUL);
                        self.input_position += 1;
                    },
                    '/' => {
                        self.current_token = Token::DIV;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::DIV);
                        self.input_position += 1;
                    },
                    '(' => {
                        self.current_token = Token::PARENS_L;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::PARENS_L);
                        self.input_position += 1;
                    },
                    '{' => {
                        self.current_token = Token::BRACKET_L;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::BRACKET_L);
                        self.input_position += 1;
                    },
                    '[' => {
                        self.current_token = Token::BRACE_L;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::BRACE_L);
                        self.input_position += 1;
                    },
                    ']' => {
                        self.current_token = Token::BRACE_R;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::BRACE_R);
                        self.input_position += 1;
                    },
                    '}' => {
                        self.current_token = Token::BRACKET_R;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::BRACKET_R);
                        self.input_position += 1;
                    },
                    ')' => {
                        self.current_token = Token::PARENS_R;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::PARENS_R);
                        self.input_position += 1;
                    },
                    '&' => {
                        self.current_token = Token::AND;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::AND);
                        self.input_position += 1;
                    },
                    '|' => {
                        self.current_token = Token::OR;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::OR);
                        self.input_position += 1;
                    },
                    '.' => {
                        self.current_token = Token::POINT;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::POINT);
                        self.input_position += 1;
                    },
                    ',' => {
                        self.current_token = Token::COMMA;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::COMMA);
                        self.input_position += 1;
                    },
                    ':' => {
                        self.current_token = Token::COLON;
                        self.current_state = LexerState::OPERATION_STATE;
                        self.token_vector.push(Token::COLON);
                        self.input_position += 1;
                    },
                    ';' => {
                        self.current_token = Token::SEMICOLON;
                        self.current_state = LexerState::END_STATE;
                        self.token_vector.push(Token::SEMICOLON);
                        self.input_position += 1;
                    },
                    '!' => {
                        if self.input_string.chars().nth((self.input_position + 1) as usize) == Option::from('=') {
                            self.current_token = Token:: NEQ;
                            self.current_state = LexerState::OPERATION_STATE;
                            self.token_vector.push(Token::NEQ);
                            self.input_position += 2;
                        } else {
                            self.current_token = Token::NOT;
                            self.current_state = LexerState::END_STATE;
                            self.token_vector.push(Token::NOT);
                            self.input_position += 1;
                        }
                    },
                    _ => {
                        println!("unhandled character: {}", ch);
                    }
                }

            }

            self.input_position += 1;
            print!("{:?} ", self.current_token);

        }

        // Handle the end of input
        Token::EOI
    }


    pub fn curr(&self) -> Token {
        if self.input_string.is_empty() {
            return Token::EOI;
        }

        let copy = self.current_token.clone();
        return copy;
    }

    //this needs fixed from infinite loop
    pub fn print_tokens(&mut self) {
        //print tokens in the input buffer using curr() and advance()
        while self.curr() != Token::EOI {
            println!("{:?}", self.advance());
        }
    }
}
