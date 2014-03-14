// $ANTLR 3.4 /home/nickpeck/NetBeansProjects/HumbleV3/humble.g 2014-02-06 18:13:26

package humble.compiler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class humbleLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int AS=5;
    public static final int BINDS=6;
    public static final int BOOL=7;
    public static final int COLON=8;
    public static final int COMMA=9;
    public static final int COMMENT=10;
    public static final int DEF=11;
    public static final int DEREF=12;
    public static final int DIV=13;
    public static final int DO=14;
    public static final int ELSE=15;
    public static final int EOL=16;
    public static final int EXTENDS=17;
    public static final int IDENT=18;
    public static final int IF=19;
    public static final int IMPORT=20;
    public static final int IS=21;
    public static final int LAB=22;
    public static final int LAMBDA=23;
    public static final int LINE_COMMENT=24;
    public static final int LPAREN=25;
    public static final int LSB=26;
    public static final int MINUS=27;
    public static final int MOD=28;
    public static final int MULT=29;
    public static final int NOT=30;
    public static final int NUMBER=31;
    public static final int OR=32;
    public static final int PACKAGE=33;
    public static final int PLUS=34;
    public static final int RAB=35;
    public static final int RPAREN=36;
    public static final int RSB=37;
    public static final int STR=38;
    public static final int TAIL=39;
    public static final int THEN=40;
    public static final int WHITESPACE=41;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public humbleLexer() {} 
    public humbleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public humbleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/nickpeck/NetBeansProjects/HumbleV3/humble.g"; }

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:38:8: ( 'import' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:38:10: 'import'
            {
            match("import"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "PACKAGE"
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:39:9: ( 'package' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:39:11: 'package'
            {
            match("package"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PACKAGE"

    // $ANTLR start "DEF"
    public final void mDEF() throws RecognitionException {
        try {
            int _type = DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:40:5: ( '@' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:40:7: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEF"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:41:4: ( '::' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:41:6: '::'
            {
            match("::"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "DEREF"
    public final void mDEREF() throws RecognitionException {
        try {
            int _type = DEREF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:42:7: ( 'as' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:42:9: 'as'
            {
            match("as"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEREF"

    // $ANTLR start "TAIL"
    public final void mTAIL() throws RecognitionException {
        try {
            int _type = TAIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:43:6: ( 'tail' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:43:8: 'tail'
            {
            match("tail"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TAIL"

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            int _type = EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:44:5: ( ';' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:44:7: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EOL"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:45:7: ( ':' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:45:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "BINDS"
    public final void mBINDS() throws RecognitionException {
        try {
            int _type = BINDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:46:7: ( '->' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:46:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BINDS"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:47:8: ( '(' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:47:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:48:8: ( ')' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:48:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:49:7: ( ',' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:49:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LSB"
    public final void mLSB() throws RecognitionException {
        try {
            int _type = LSB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:50:5: ( '[' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:50:7: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LSB"

    // $ANTLR start "RSB"
    public final void mRSB() throws RecognitionException {
        try {
            int _type = RSB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:51:5: ( ']' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:51:7: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RSB"

    // $ANTLR start "LAB"
    public final void mLAB() throws RecognitionException {
        try {
            int _type = LAB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:52:5: ( '<' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:52:7: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LAB"

    // $ANTLR start "RAB"
    public final void mRAB() throws RecognitionException {
        try {
            int _type = RAB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:53:5: ( '>' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:53:7: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RAB"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:54:6: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:54:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:54:17: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "LAMBDA"
    public final void mLAMBDA() throws RecognitionException {
        try {
            int _type = LAMBDA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:55:8: ( '\\\\' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:55:10: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LAMBDA"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:56:4: ( 'do' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:56:6: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:57:4: ( 'if' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:57:6: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:58:6: ( 'else' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:58:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:59:6: ( 'then' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:59:8: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:61:4: ( '|' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:61:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "EXTENDS"
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:63:9: ( 'extends' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:63:11: 'extends'
            {
            match("extends"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXTENDS"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:64:5: ( '&' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:64:7: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:65:5: ( '!' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:65:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:66:4: ( 'is' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:66:6: 'is'
            {
            match("is"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:67:6: ( '+' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:67:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:68:7: ( '-' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:68:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:69:6: ( '*' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:69:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:70:5: ( '/' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:70:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:71:5: ( '%' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:71:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:77:9: ( ( '0' .. '9' )+ )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:77:11: ( '0' .. '9' )+
            {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:77:11: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:78:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )+ )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:78:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )+
            {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:78:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='.'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "STR"
    public final void mSTR() throws RecognitionException {
        try {
            int _type = STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:79:6: ( '\"' (~ ( '\"' ) )* '\"' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:79:8: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); 

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:79:12: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:81:5: ( '/*' ( . )* '*/' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:81:7: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:81:12: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:81:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:83:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:83:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:83:12: (~ ( '\\n' | '\\r' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:83:26: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:83:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:84:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:84:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:84:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||(LA8_0 >= '\f' && LA8_0 <= '\r')||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:8: ( IMPORT | PACKAGE | DEF | AS | DEREF | TAIL | EOL | COLON | BINDS | LPAREN | RPAREN | COMMA | LSB | RSB | LAB | RAB | BOOL | LAMBDA | DO | IF | ELSE | THEN | OR | EXTENDS | AND | NOT | IS | PLUS | MINUS | MULT | DIV | MOD | NUMBER | IDENT | STR | COMMENT | LINE_COMMENT | WHITESPACE )
        int alt9=38;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:10: IMPORT
                {
                mIMPORT(); 


                }
                break;
            case 2 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:17: PACKAGE
                {
                mPACKAGE(); 


                }
                break;
            case 3 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:25: DEF
                {
                mDEF(); 


                }
                break;
            case 4 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:29: AS
                {
                mAS(); 


                }
                break;
            case 5 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:32: DEREF
                {
                mDEREF(); 


                }
                break;
            case 6 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:38: TAIL
                {
                mTAIL(); 


                }
                break;
            case 7 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:43: EOL
                {
                mEOL(); 


                }
                break;
            case 8 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:47: COLON
                {
                mCOLON(); 


                }
                break;
            case 9 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:53: BINDS
                {
                mBINDS(); 


                }
                break;
            case 10 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:59: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 11 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:66: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 12 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:73: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 13 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:79: LSB
                {
                mLSB(); 


                }
                break;
            case 14 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:83: RSB
                {
                mRSB(); 


                }
                break;
            case 15 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:87: LAB
                {
                mLAB(); 


                }
                break;
            case 16 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:91: RAB
                {
                mRAB(); 


                }
                break;
            case 17 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:95: BOOL
                {
                mBOOL(); 


                }
                break;
            case 18 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:100: LAMBDA
                {
                mLAMBDA(); 


                }
                break;
            case 19 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:107: DO
                {
                mDO(); 


                }
                break;
            case 20 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:110: IF
                {
                mIF(); 


                }
                break;
            case 21 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:113: ELSE
                {
                mELSE(); 


                }
                break;
            case 22 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:118: THEN
                {
                mTHEN(); 


                }
                break;
            case 23 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:123: OR
                {
                mOR(); 


                }
                break;
            case 24 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:126: EXTENDS
                {
                mEXTENDS(); 


                }
                break;
            case 25 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:134: AND
                {
                mAND(); 


                }
                break;
            case 26 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:138: NOT
                {
                mNOT(); 


                }
                break;
            case 27 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:142: IS
                {
                mIS(); 


                }
                break;
            case 28 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:145: PLUS
                {
                mPLUS(); 


                }
                break;
            case 29 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:150: MINUS
                {
                mMINUS(); 


                }
                break;
            case 30 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:156: MULT
                {
                mMULT(); 


                }
                break;
            case 31 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:161: DIV
                {
                mDIV(); 


                }
                break;
            case 32 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:165: MOD
                {
                mMOD(); 


                }
                break;
            case 33 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:169: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 34 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:176: IDENT
                {
                mIDENT(); 


                }
                break;
            case 35 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:182: STR
                {
                mSTR(); 


                }
                break;
            case 36 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:186: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 37 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:194: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 38 :
                // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:1:207: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\2\34\1\uffff\1\44\2\34\1\uffff\1\52\7\uffff\1\34\1\uffff"+
        "\2\34\5\uffff\1\61\1\uffff\1\62\3\uffff\1\34\1\64\1\65\1\34\2\uffff"+
        "\1\67\3\34\2\uffff\1\34\1\74\2\34\4\uffff\1\34\2\uffff\1\34\1\uffff"+
        "\4\34\1\uffff\4\34\1\111\1\112\1\113\1\34\1\115\3\34\3\uffff\1\112"+
        "\1\uffff\1\34\1\122\2\34\1\uffff\1\125\1\126\2\uffff";
    static final String DFA9_eofS =
        "\127\uffff";
    static final String DFA9_minS =
        "\1\11\1\146\1\141\1\uffff\1\72\1\163\1\141\1\uffff\1\76\7\uffff"+
        "\1\141\1\uffff\1\157\1\154\5\uffff\1\52\1\uffff\1\56\3\uffff\1\160"+
        "\2\56\1\143\2\uffff\1\56\1\151\1\165\1\145\2\uffff\1\154\1\56\1"+
        "\163\1\164\4\uffff\1\157\2\uffff\1\153\1\uffff\1\154\1\145\1\156"+
        "\1\163\1\uffff\2\145\1\162\1\141\3\56\1\145\1\56\1\156\1\164\1\147"+
        "\3\uffff\1\56\1\uffff\1\144\1\56\1\145\1\163\1\uffff\2\56\2\uffff";
    static final String DFA9_maxS =
        "\1\174\1\163\1\141\1\uffff\1\72\1\163\1\162\1\uffff\1\76\7\uffff"+
        "\1\141\1\uffff\1\157\1\170\5\uffff\1\57\1\uffff\1\172\3\uffff\1"+
        "\160\2\172\1\143\2\uffff\1\172\1\151\1\165\1\145\2\uffff\1\154\1"+
        "\172\1\163\1\164\4\uffff\1\157\2\uffff\1\153\1\uffff\1\154\1\145"+
        "\1\156\1\163\1\uffff\2\145\1\162\1\141\3\172\1\145\1\172\1\156\1"+
        "\164\1\147\3\uffff\1\172\1\uffff\1\144\1\172\1\145\1\163\1\uffff"+
        "\2\172\2\uffff";
    static final String DFA9_acceptS =
        "\3\uffff\1\3\3\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1"+
        "\20\1\uffff\1\22\2\uffff\1\27\1\31\1\32\1\34\1\36\1\uffff\1\40\1"+
        "\uffff\1\42\1\43\1\46\4\uffff\1\4\1\10\4\uffff\1\11\1\35\4\uffff"+
        "\1\44\1\45\1\37\1\41\1\uffff\1\24\1\33\1\uffff\1\5\4\uffff\1\23"+
        "\14\uffff\1\6\1\21\1\26\1\uffff\1\25\4\uffff\1\1\2\uffff\1\2\1\30";
    static final String DFA9_specialS =
        "\127\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\36\1\uffff\2\36\22\uffff\1\36\1\26\1\35\2\uffff\1\32\1\25"+
            "\1\uffff\1\11\1\12\1\30\1\27\1\13\1\10\1\34\1\31\12\33\1\4\1"+
            "\7\1\16\1\uffff\1\17\1\uffff\1\3\32\34\1\14\1\21\1\15\1\uffff"+
            "\1\34\1\uffff\1\5\2\34\1\22\1\23\1\20\2\34\1\1\6\34\1\2\3\34"+
            "\1\6\6\34\1\uffff\1\24",
            "\1\40\6\uffff\1\37\5\uffff\1\41",
            "\1\42",
            "",
            "\1\43",
            "\1\45",
            "\1\46\6\uffff\1\50\11\uffff\1\47",
            "",
            "\1\51",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\53",
            "",
            "\1\54",
            "\1\55\13\uffff\1\56",
            "",
            "",
            "",
            "",
            "",
            "\1\57\4\uffff\1\60",
            "",
            "\1\34\1\uffff\12\33\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "\1\63",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\66",
            "",
            "",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\70",
            "\1\71",
            "\1\72",
            "",
            "",
            "\1\73",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\75",
            "\1\76",
            "",
            "",
            "",
            "",
            "\1\77",
            "",
            "",
            "\1\100",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\114",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "",
            "",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\121",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\123",
            "\1\124",
            "",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( IMPORT | PACKAGE | DEF | AS | DEREF | TAIL | EOL | COLON | BINDS | LPAREN | RPAREN | COMMA | LSB | RSB | LAB | RAB | BOOL | LAMBDA | DO | IF | ELSE | THEN | OR | EXTENDS | AND | NOT | IS | PLUS | MINUS | MULT | DIV | MOD | NUMBER | IDENT | STR | COMMENT | LINE_COMMENT | WHITESPACE );";
        }
    }
 

}