package desktopapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Exceptions.CharUndef;
import Exceptions.ZeroDivException;
import calculation.*;
public class _Lexeme {


        public static HashMap<String, Function> functionMap;

        public static void main(String[] args) throws ZeroDivException, CharUndef {
            HashMap<String, Integer> parameters = new HashMap<String, Integer>();
            for(int i=0;i<2;i++){
                parameters.put("a", i);
                parameters.put("b", i+1);
                
            }
           

            //String expressionText = "122 - 34 - 3* (55 + 5* (3 - 2)) * 2";
            String expression_Text = "(5+0)/2+a*b/a";
            String expressionText = Prm.get_str_wth_param(expression_Text,parameters);
            List<Lexeme> lexemes = lexAnalyze(expressionText);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
            System.out.println(expr(lexemeBuffer).Calc());

        }
        public static double calc(String name ) throws ZeroDivException{
            List<Lexeme> lexemes = lexAnalyze(name);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
            return expr(lexemeBuffer).Calc(); 
        }
        public enum LexemeType {
            LEFT_BRACKET, RIGHT_BRACKET,
            OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
            NUMBER,
            EOF;
        }

        public interface Function {
            int apply(ArrayList<Double> args);
        }

     

        public static class Lexeme {
            LexemeType type;
            String value;

            public Lexeme(LexemeType type, String value) {
                this.type = type;
                this.value = value;
            }

            public Lexeme(LexemeType type, Character value) {
                this.type = type;
                this.value = value.toString();
            }

            @Override
            public String toString() {
                return "Lexeme{" +
                        "type=" + type +
                        ", value='" + value + '\'' +
                        '}';
            }
        }

        public static class LexemeBuffer {
            private int pos;

            public List<Lexeme> lexemes;

            public LexemeBuffer(List<Lexeme> lexemes) {
                this.lexemes = lexemes;
            }

            public Lexeme next() {
                return lexemes.get(pos++);
            }

            public void back() {
                pos--;
            }

            public int getPos() {
                return pos;
            }
        }

        public static List<Lexeme> lexAnalyze(String expText) {
            ArrayList<Lexeme> lexemes = new ArrayList<>();
            int pos = 0;
            while (pos< expText.length()) {
                char c = expText.charAt(pos);
                switch (c) {
                    case '(':
                        lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                        pos++;
                        continue;
                    case ')':
                        lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                        pos++;
                        continue;
                    case '+':
                        lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                        pos++;
                        continue;
                    case '-':
                        lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                        pos++;
                        continue;
                    case '*':
                        lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                        pos++;
                        continue;
                    case '/':
                        lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                        pos++;
                        continue;
                 
                    default:
                        if (c <= '9' && c >= '0') {
                            StringBuilder sb = new StringBuilder();
                            do {
                                sb.append(c);
                                pos++;
                                if (pos >= expText.length()) {
                                    break;
                                }
                                c = expText.charAt(pos);
                            } while (c <= '9' && c >= '0');
                            lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                            } else {
                                pos++;
                            }
                        }
                }
            
            lexemes.add(new Lexeme(LexemeType.EOF, ""));
            return lexemes;
        }

        public static Sum expr(LexemeBuffer lexemes) throws ZeroDivException {
            Lexeme lexeme = lexemes.next();
            if (lexeme.type == LexemeType.EOF) {
                return null;
            } else {
                lexemes.back();
                return plusminus(lexemes);
            }
        }

        public static Sum plusminus(LexemeBuffer lexemes) throws ZeroDivException {
            Sum value = new Sum(multdiv(lexemes),new Value(0));
            while (true) {
                Lexeme lexeme = lexemes.next();
                switch (lexeme.type) {
                    case OP_PLUS:
                        value = new Sum(multdiv(lexemes),value);
                        break;
                    case OP_MINUS:
                        value = new Sum(value,new Mult(multdiv(lexemes),new Value(-1)));
                        break;
                    case EOF:
                    case RIGHT_BRACKET:
                        lexemes.back();
                        return value;
                    default:
                        throw new RuntimeException("Unexpected token: " + lexeme.value
                                + " at position: " + lexemes.getPos());
                }
            }
        }

        public static Mult multdiv(LexemeBuffer lexemes) throws ZeroDivException {
            Mult value =new Mult(factor(lexemes),new Value(1));
            while (true) {
                Lexeme lexeme = lexemes.next();
                switch (lexeme.type) {
                    case OP_MUL:
                        value =new Mult(factor(lexemes),value);
                        break;
                    case OP_DIV:
                        value =new Mult(new Div(new Value(1),factor(lexemes)),value);
                        break;
                    case EOF:
                    case RIGHT_BRACKET:
                   
                    case OP_PLUS:
                    case OP_MINUS:
                        lexemes.back();
                        return value;
                    default:
                        throw new RuntimeException("Unexpected token: " + lexeme.value
                                + " at position: " + lexemes.getPos());
                }
            }
        }

        public static ICalc factor(LexemeBuffer lexemes) throws ZeroDivException {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case NUMBER:
                    return ICalc.parseICalc(lexeme.value);
                case LEFT_BRACKET:
                   Sum value = plusminus(lexemes);
                    lexeme = lexemes.next();
                    if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                        throw new RuntimeException("Unexpected token: " + lexeme.value
                                + " at position: " + lexemes.getPos());
                    }
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
            }
        }

        public static int func(LexemeBuffer lexemeBuffer) throws ZeroDivException {
            String name = lexemeBuffer.next().value;
            Lexeme lexeme = lexemeBuffer.next();

            if (lexeme.type != LexemeType.LEFT_BRACKET) {
                throw new RuntimeException("Wrong function call syntax at " + lexeme.value);
            }

            ArrayList<Double> args = new ArrayList<>();

            lexeme = lexemeBuffer.next();
            if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                lexemeBuffer.back();
            }
            return functionMap.get(name).apply(args);
        }

    }

