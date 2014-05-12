// $ANTLR 3.4 /home/nickpeck/Humble/humble.g 2014-04-16 21:17:42

package humble.compiler;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class humbleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "AS", "BINDS", "BOOL", "COLON", "COMMA", "COMMENT", "DEF", "DEREF", "DIV", "DO", "DOT", "ELSE", "EOL", "EXTENDS", "IDENT", "IF", "IMPORT", "IS", "LAB", "LAMBDA", "LINE_COMMENT", "LPAREN", "LSB", "MINUS", "MOD", "MULT", "NEW", "NOT", "NUMBER", "OR", "PACKAGE", "PLUS", "RAB", "RPAREN", "RSB", "STR", "TAIL", "THEN", "WHITESPACE"
    };

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
    public static final int DOT=15;
    public static final int ELSE=16;
    public static final int EOL=17;
    public static final int EXTENDS=18;
    public static final int IDENT=19;
    public static final int IF=20;
    public static final int IMPORT=21;
    public static final int IS=22;
    public static final int LAB=23;
    public static final int LAMBDA=24;
    public static final int LINE_COMMENT=25;
    public static final int LPAREN=26;
    public static final int LSB=27;
    public static final int MINUS=28;
    public static final int MOD=29;
    public static final int MULT=30;
    public static final int NEW=31;
    public static final int NOT=32;
    public static final int NUMBER=33;
    public static final int OR=34;
    public static final int PACKAGE=35;
    public static final int PLUS=36;
    public static final int RAB=37;
    public static final int RPAREN=38;
    public static final int RSB=39;
    public static final int STR=40;
    public static final int TAIL=41;
    public static final int THEN=42;
    public static final int WHITESPACE=43;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public humbleParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public humbleParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return humbleParser.tokenNames; }
    public String getGrammarFileName() { return "/home/nickpeck/Humble/humble.g"; }


      private String moduleName;
      private ArrayList<String> imports = new ArrayList<String>();

      public String getModuleName() {
        return moduleName;
      }
      
      public void setModuleName(String name) {
      	moduleName = name;
      }



    // $ANTLR start "package_statement"
    // /home/nickpeck/Humble/humble.g:89:1: package_statement returns [String result] : PACKAGE i1= IDENT ( DOT i2= IDENT )* EOL ;
    public final String package_statement() throws RecognitionException {
        String result = null;


        Token i1=null;
        Token i2=null;

        try {
            // /home/nickpeck/Humble/humble.g:90:2: ( PACKAGE i1= IDENT ( DOT i2= IDENT )* EOL )
            // /home/nickpeck/Humble/humble.g:90:4: PACKAGE i1= IDENT ( DOT i2= IDENT )* EOL
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_package_statement438); 

            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_package_statement442); 

            result = i1.getText();

            // /home/nickpeck/Humble/humble.g:91:3: ( DOT i2= IDENT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DOT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:92:4: DOT i2= IDENT
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_package_statement453); 

            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_package_statement457); 

            	    result = result + "." + i2.getText();

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,EOL,FOLLOW_EOL_in_package_statement466); 

            result ="package " + result + ";";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "package_statement"



    // $ANTLR start "extends_statement"
    // /home/nickpeck/Humble/humble.g:97:1: extends_statement returns [String result] : EXTENDS i= IDENT EOL ;
    public final String extends_statement() throws RecognitionException {
        String result = null;


        Token i=null;

        try {
            // /home/nickpeck/Humble/humble.g:98:2: ( EXTENDS i= IDENT EOL )
            // /home/nickpeck/Humble/humble.g:98:4: EXTENDS i= IDENT EOL
            {
            match(input,EXTENDS,FOLLOW_EXTENDS_in_extends_statement486); 

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_extends_statement490); 

            match(input,EOL,FOLLOW_EOL_in_extends_statement492); 

            result ="extends " + i.getText();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "extends_statement"



    // $ANTLR start "import_statment"
    // /home/nickpeck/Humble/humble.g:102:1: import_statment returns [String result] : IMPORT i1= IDENT ( DOT i2= IDENT )* EOL ;
    public final String import_statment() throws RecognitionException {
        String result = null;


        Token i1=null;
        Token i2=null;

        try {
            // /home/nickpeck/Humble/humble.g:103:2: ( IMPORT i1= IDENT ( DOT i2= IDENT )* EOL )
            // /home/nickpeck/Humble/humble.g:103:4: IMPORT i1= IDENT ( DOT i2= IDENT )* EOL
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_import_statment511); 

            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_import_statment515); 

            result = i1.getText();

            // /home/nickpeck/Humble/humble.g:104:3: ( DOT i2= IDENT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==DOT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:105:4: DOT i2= IDENT
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_import_statment526); 

            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_import_statment530); 

            	    result = result + "." + i2.getText();

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,EOL,FOLLOW_EOL_in_import_statment539); 


            			if(result.endsWith(".*")) {
            				System.err.println("Package imports are not allowed in Humble.");
            				System.exit(1);
            			}
            		

            imports.add(result);

            result ="import " + result + ";";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "import_statment"



    // $ANTLR start "dereference"
    // /home/nickpeck/Humble/humble.g:117:1: dereference returns [LinkedList<String> result] :i= IDENT DEREF LSB ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )? RSB ;
    public final LinkedList<String> dereference() throws RecognitionException {
        LinkedList<String> result = null;


        Token i=null;
        Token i2=null;
        Token i3=null;

        try {
            // /home/nickpeck/Humble/humble.g:118:2: (i= IDENT DEREF LSB ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )? RSB )
            // /home/nickpeck/Humble/humble.g:118:4: i= IDENT DEREF LSB ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )? RSB
            {
            result = new LinkedList<String>();

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_dereference573); 

            result.add(i.getText());

            match(input,DEREF,FOLLOW_DEREF_in_dereference579); 

            match(input,LSB,FOLLOW_LSB_in_dereference586); 

            // /home/nickpeck/Humble/humble.g:122:3: ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:123:4: (i2= IDENT ) ( COMMA (i3= IDENT ) )*
                    {
                    // /home/nickpeck/Humble/humble.g:123:4: (i2= IDENT )
                    // /home/nickpeck/Humble/humble.g:124:6: i2= IDENT
                    {
                    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_dereference604); 

                    result.add(i2.getText());

                    }


                    // /home/nickpeck/Humble/humble.g:128:4: ( COMMA (i3= IDENT ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==COMMA) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:129:5: COMMA (i3= IDENT )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_dereference630); 

                    	    // /home/nickpeck/Humble/humble.g:130:5: (i3= IDENT )
                    	    // /home/nickpeck/Humble/humble.g:131:6: i3= IDENT
                    	    {
                    	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_dereference646); 

                    	    result.add(i3.getText());

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RSB,FOLLOW_RSB_in_dereference672); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "dereference"



    // $ANTLR start "list_slice"
    // /home/nickpeck/Humble/humble.g:142:1: list_slice returns [LinkedList<String> result] :i1= IDENT DEREF LSB i2= IDENT COLON i3= IDENT RSB ;
    public final LinkedList<String> list_slice() throws RecognitionException {
        LinkedList<String> result = null;


        Token i1=null;
        Token i2=null;
        Token i3=null;

        try {
            // /home/nickpeck/Humble/humble.g:143:2: (i1= IDENT DEREF LSB i2= IDENT COLON i3= IDENT RSB )
            // /home/nickpeck/Humble/humble.g:143:4: i1= IDENT DEREF LSB i2= IDENT COLON i3= IDENT RSB
            {
            result = new LinkedList<String>();

            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_list_slice698); 

            result.add(i1.getText());

            match(input,DEREF,FOLLOW_DEREF_in_list_slice704); 

            match(input,LSB,FOLLOW_LSB_in_list_slice711); 

            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_list_slice717); 

            result.add(i2.getText());

            match(input,COLON,FOLLOW_COLON_in_list_slice724); 

            i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_list_slice730); 

            result.add(i3.getText());

            match(input,RSB,FOLLOW_RSB_in_list_slice736); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "list_slice"



    // $ANTLR start "type"
    // /home/nickpeck/Humble/humble.g:153:1: type returns [String result] : LAB i= IDENT RAB ;
    public final String type() throws RecognitionException {
        String result = null;


        Token i=null;

        try {
            // /home/nickpeck/Humble/humble.g:154:2: ( LAB i= IDENT RAB )
            // /home/nickpeck/Humble/humble.g:155:3: LAB i= IDENT RAB
            {
            match(input,LAB,FOLLOW_LAB_in_type755); 

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_type759); 

            match(input,RAB,FOLLOW_RAB_in_type761); 

            result = " new _Class(" + i.getText() + ".class)";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "obj"
    // /home/nickpeck/Humble/humble.g:158:1: obj returns [String result] : NEW i= IDENT LPAREN c1= callable ( COMMA c2= callable )* RPAREN ;
    public final String obj() throws RecognitionException {
        String result = null;


        Token i=null;
        String c1 =null;

        String c2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:159:2: ( NEW i= IDENT LPAREN c1= callable ( COMMA c2= callable )* RPAREN )
            // /home/nickpeck/Humble/humble.g:160:3: NEW i= IDENT LPAREN c1= callable ( COMMA c2= callable )* RPAREN
            {
            match(input,NEW,FOLLOW_NEW_in_obj781); 

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_obj785); 

            StringBuilder args = new StringBuilder("(");

            match(input,LPAREN,FOLLOW_LPAREN_in_obj796); 

            pushFollow(FOLLOW_callable_in_obj804);
            c1=callable();

            state._fsp--;


            args.append(c1.toString());

            // /home/nickpeck/Humble/humble.g:164:4: ( COMMA c2= callable )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:165:5: COMMA c2= callable
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_obj817); 

            	    pushFollow(FOLLOW_callable_in_obj826);
            	    c2=callable();

            	    state._fsp--;


            	    args.append(", ");

            	    args.append(c2.toString());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,RPAREN,FOLLOW_RPAREN_in_obj851); 

            args.append(")");

            result = " new " + i.getText() + args.toString();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "obj"



    // $ANTLR start "callable"
    // /home/nickpeck/Humble/humble.g:175:1: callable returns [String result] : (id= IDENT |s= STR |b= BOOL |n= NUMBER |t= type );
    public final String callable() throws RecognitionException {
        String result = null;


        Token id=null;
        Token s=null;
        Token b=null;
        Token n=null;
        String t =null;


        try {
            // /home/nickpeck/Humble/humble.g:176:2: (id= IDENT |s= STR |b= BOOL |n= NUMBER |t= type )
            int alt6=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt6=1;
                }
                break;
            case STR:
                {
                alt6=2;
                }
                break;
            case BOOL:
                {
                alt6=3;
                }
                break;
            case NUMBER:
                {
                alt6=4;
                }
                break;
            case LAB:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:176:4: id= IDENT
                    {
                    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_callable875); 

                    result = id.getText();

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:177:5: s= STR
                    {
                    s=(Token)match(input,STR,FOLLOW_STR_in_callable885); 

                    result = " new _String(" + s.getText() + ")";

                    }
                    break;
                case 3 :
                    // /home/nickpeck/Humble/humble.g:179:5: b= BOOL
                    {
                    b=(Token)match(input,BOOL,FOLLOW_BOOL_in_callable897); 

                    result = " new _Boolean(" + b.getText() + ")";

                    }
                    break;
                case 4 :
                    // /home/nickpeck/Humble/humble.g:184:5: n= NUMBER
                    {
                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_callable919); 

                    result = " new _Number(" + n.getText() + ")";

                    }
                    break;
                case 5 :
                    // /home/nickpeck/Humble/humble.g:185:5: t= type
                    {
                    pushFollow(FOLLOW_type_in_callable929);
                    t=type();

                    state._fsp--;


                    result = t.toString();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "callable"



    // $ANTLR start "tuple"
    // /home/nickpeck/Humble/humble.g:189:1: tuple returns [StringBuilder result] : LPAREN ( (e1= statement |f1= function ) ( COMMA (e2= statement |f2= function ) )* )? RPAREN ;
    public final StringBuilder tuple() throws RecognitionException {
        StringBuilder result = null;


        StringBuilder e1 =null;

        StringBuilder f1 =null;

        StringBuilder e2 =null;

        StringBuilder f2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:190:2: ( LPAREN ( (e1= statement |f1= function ) ( COMMA (e2= statement |f2= function ) )* )? RPAREN )
            // /home/nickpeck/Humble/humble.g:191:3: LPAREN ( (e1= statement |f1= function ) ( COMMA (e2= statement |f2= function ) )* )? RPAREN
            {
            result = new StringBuilder();

            match(input,LPAREN,FOLLOW_LPAREN_in_tuple957); 

            result.append('(');

            // /home/nickpeck/Humble/humble.g:193:3: ( (e1= statement |f1= function ) ( COMMA (e2= statement |f2= function ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==AS||LA10_0==BOOL||LA10_0==DEF||(LA10_0 >= IDENT && LA10_0 <= IF)||(LA10_0 >= LAB && LA10_0 <= LAMBDA)||(LA10_0 >= LPAREN && LA10_0 <= LSB)||(LA10_0 >= NEW && LA10_0 <= NUMBER)||LA10_0==STR) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:194:4: (e1= statement |f1= function ) ( COMMA (e2= statement |f2= function ) )*
                    {
                    // /home/nickpeck/Humble/humble.g:194:4: (e1= statement |f1= function )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==AS||LA7_0==BOOL||(LA7_0 >= IDENT && LA7_0 <= IF)||(LA7_0 >= LAB && LA7_0 <= LAMBDA)||(LA7_0 >= LPAREN && LA7_0 <= LSB)||(LA7_0 >= NEW && LA7_0 <= NUMBER)||LA7_0==STR) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==DEF) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }
                    switch (alt7) {
                        case 1 :
                            // /home/nickpeck/Humble/humble.g:195:6: e1= statement
                            {
                            pushFollow(FOLLOW_statement_in_tuple977);
                            e1=statement();

                            state._fsp--;


                            result.append(e1.toString());

                            }
                            break;
                        case 2 :
                            // /home/nickpeck/Humble/humble.g:196:8: f1= function
                            {
                            pushFollow(FOLLOW_function_in_tuple990);
                            f1=function();

                            state._fsp--;


                            result.append(f1.toString());

                            }
                            break;

                    }


                    // /home/nickpeck/Humble/humble.g:199:4: ( COMMA (e2= statement |f2= function ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:200:5: COMMA (e2= statement |f2= function )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_tuple1012); 

                    	    result.append(", ");

                    	    // /home/nickpeck/Humble/humble.g:201:5: (e2= statement |f2= function )
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==AS||LA8_0==BOOL||(LA8_0 >= IDENT && LA8_0 <= IF)||(LA8_0 >= LAB && LA8_0 <= LAMBDA)||(LA8_0 >= LPAREN && LA8_0 <= LSB)||(LA8_0 >= NEW && LA8_0 <= NUMBER)||LA8_0==STR) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==DEF) ) {
                    	        alt8=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 8, 0, input);

                    	        throw nvae;

                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // /home/nickpeck/Humble/humble.g:202:6: e2= statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_tuple1029);
                    	            e2=statement();

                    	            state._fsp--;


                    	            result.append(e2.toString());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /home/nickpeck/Humble/humble.g:203:8: f2= function
                    	            {
                    	            pushFollow(FOLLOW_function_in_tuple1042);
                    	            f2=function();

                    	            state._fsp--;


                    	            result.append(f2.toString());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_tuple1064); 

            result.append(')');

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "tuple"



    // $ANTLR start "list"
    // /home/nickpeck/Humble/humble.g:209:1: list returns [StringBuilder result] :l= LSB ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )? RSB ;
    public final StringBuilder list() throws RecognitionException {
        StringBuilder result = null;


        Token l=null;
        String e1 =null;

        String e2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:210:2: (l= LSB ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )? RSB )
            // /home/nickpeck/Humble/humble.g:211:3: l= LSB ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )? RSB
            {
            result = new StringBuilder();

            l=(Token)match(input,LSB,FOLLOW_LSB_in_list1091); 

            result.append(" new _List(");

            // /home/nickpeck/Humble/humble.g:213:3: ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==BOOL||(LA12_0 >= IDENT && LA12_0 <= IF)||LA12_0==LAB||(LA12_0 >= LPAREN && LA12_0 <= LSB)||(LA12_0 >= NEW && LA12_0 <= NUMBER)||LA12_0==STR) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:214:4: (e1= compound_expression ) ( COMMA (e2= compound_expression ) )*
                    {
                    // /home/nickpeck/Humble/humble.g:214:4: (e1= compound_expression )
                    // /home/nickpeck/Humble/humble.g:215:6: e1= compound_expression
                    {
                    pushFollow(FOLLOW_compound_expression_in_list1111);
                    e1=compound_expression();

                    state._fsp--;


                    result.append(e1.toString());

                    }


                    // /home/nickpeck/Humble/humble.g:218:4: ( COMMA (e2= compound_expression ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:219:5: COMMA (e2= compound_expression )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_list1132); 

                    	    result.append(", ");

                    	    // /home/nickpeck/Humble/humble.g:220:5: (e2= compound_expression )
                    	    // /home/nickpeck/Humble/humble.g:221:6: e2= compound_expression
                    	    {
                    	    pushFollow(FOLLOW_compound_expression_in_list1149);
                    	    e2=compound_expression();

                    	    state._fsp--;


                    	    result.append(e2.toString());

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RSB,FOLLOW_RSB_in_list1170); 

            result.append(")");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "list"



    // $ANTLR start "expression"
    // /home/nickpeck/Humble/humble.g:228:1: expression returns [StringBuilder result] : (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list |o= obj t3= tuple |o2= obj ) ;
    public final StringBuilder expression() throws RecognitionException {
        StringBuilder result = null;


        String a1 =null;

        String a2 =null;

        StringBuilder t1 =null;

        StringBuilder t2 =null;

        StringBuilder li =null;

        String o =null;

        StringBuilder t3 =null;

        String o2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:229:2: ( (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list |o= obj t3= tuple |o2= obj ) )
            // /home/nickpeck/Humble/humble.g:230:3: (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list |o= obj t3= tuple |o2= obj )
            {
            result = new StringBuilder();

            // /home/nickpeck/Humble/humble.g:231:3: (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list |o= obj t3= tuple |o2= obj )
            int alt14=6;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:232:4: a1= callable
                    {
                    pushFollow(FOLLOW_callable_in_expression1207);
                    a1=callable();

                    state._fsp--;


                    result.append(a1);

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:233:7: (a2= callable (t1= tuple )+ )
                    {
                    // /home/nickpeck/Humble/humble.g:233:7: (a2= callable (t1= tuple )+ )
                    // /home/nickpeck/Humble/humble.g:235:6: a2= callable (t1= tuple )+
                    {
                    pushFollow(FOLLOW_callable_in_expression1227);
                    a2=callable();

                    state._fsp--;


                    StringBuilder tuples1 = new StringBuilder();

                    StringBuilder tuples2 = new StringBuilder();

                    // /home/nickpeck/Humble/humble.g:238:6: (t1= tuple )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==LPAREN) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:239:7: t1= tuple
                    	    {
                    	    pushFollow(FOLLOW_tuple_in_expression1258);
                    	    t1=tuple();

                    	    state._fsp--;


                    	    tuples1.append(".call" + t1.toString());

                    	    tuples2.append(t1.toString());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    //if the callable is an imported module, then create and instance and
                    					//execute the 'tuple' within the module's callable section
                    						Boolean isImportClass = false;
                    						for(int i=0;i<imports.size();i++){
                    							if(imports.get(i).endsWith("." + a2.toString())) {
                    								isImportClass = true;
                    							}
                    						}
                    						if(isImportClass) {
                    							result.append(" new " + a2.toString() + "(){");
                    							result.append("	@Override");
                    							//append 'call', in case this is a bind operation, eg x->IO(\(x) :: print_out(x))
                    							result.append("	public Callable call(final Callable ... args){");
                    							result.append("		return " + tuples2.toString() + ".call(args);");
                    							result.append("	}");
                    							result.append("}");
                    						} else {
                    							result.append(a2);
                    							result.append(tuples1.toString());
                    						}	
                    					

                    }


                    }
                    break;
                case 3 :
                    // /home/nickpeck/Humble/humble.g:272:6: t2= tuple
                    {
                    pushFollow(FOLLOW_tuple_in_expression1303);
                    t2=tuple();

                    state._fsp--;


                    result.append(t2.toString());

                    }
                    break;
                case 4 :
                    // /home/nickpeck/Humble/humble.g:273:6: li= list
                    {
                    pushFollow(FOLLOW_list_in_expression1314);
                    li=list();

                    state._fsp--;


                    result.append(li.toString());

                    }
                    break;
                case 5 :
                    // /home/nickpeck/Humble/humble.g:274:6: o= obj t3= tuple
                    {
                    pushFollow(FOLLOW_obj_in_expression1325);
                    o=obj();

                    state._fsp--;


                    pushFollow(FOLLOW_tuple_in_expression1329);
                    t3=tuple();

                    state._fsp--;



                    				result.append(o.toString() + "{");
                    				result.append("	@Override");
                    		
                    				result.append("	public Callable call(final Callable ... args){");
                    				result.append("		return " + t3.toString() + ".call(args);");
                    				result.append("	}");
                    				result.append("}");
                    			

                    }
                    break;
                case 6 :
                    // /home/nickpeck/Humble/humble.g:284:6: o2= obj
                    {
                    pushFollow(FOLLOW_obj_in_expression1351);
                    o2=obj();

                    state._fsp--;


                    result.append(o2.toString());

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "expression"



    // $ANTLR start "compound_expression_dot"
    // /home/nickpeck/Humble/humble.g:291:1: compound_expression_dot returns [String result] : e1= expression ( DOT e2= expression )* ;
    public final String compound_expression_dot() throws RecognitionException {
        String result = null;


        StringBuilder e1 =null;

        StringBuilder e2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:292:2: (e1= expression ( DOT e2= expression )* )
            // /home/nickpeck/Humble/humble.g:293:3: e1= expression ( DOT e2= expression )*
            {
            pushFollow(FOLLOW_expression_in_compound_expression_dot1383);
            e1=expression();

            state._fsp--;


            result = e1.toString();

            // /home/nickpeck/Humble/humble.g:294:3: ( DOT e2= expression )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==DOT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:295:4: DOT e2= expression
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_compound_expression_dot1394); 

            	    pushFollow(FOLLOW_expression_in_compound_expression_dot1398);
            	    e2=expression();

            	    state._fsp--;


            	    result = result + "." + e2.toString();

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_dot"



    // $ANTLR start "compound_expression_mult_div"
    // /home/nickpeck/Humble/humble.g:299:1: compound_expression_mult_div returns [String result] : e= compound_expression_dot ( MULT e2= compound_expression_dot | DIV e3= compound_expression_dot | MOD e4= compound_expression_dot )* ;
    public final String compound_expression_mult_div() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;

        String e3 =null;

        String e4 =null;


        try {
            // /home/nickpeck/Humble/humble.g:300:2: (e= compound_expression_dot ( MULT e2= compound_expression_dot | DIV e3= compound_expression_dot | MOD e4= compound_expression_dot )* )
            // /home/nickpeck/Humble/humble.g:301:3: e= compound_expression_dot ( MULT e2= compound_expression_dot | DIV e3= compound_expression_dot | MOD e4= compound_expression_dot )*
            {
            pushFollow(FOLLOW_compound_expression_dot_in_compound_expression_mult_div1424);
            e=compound_expression_dot();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/Humble/humble.g:302:3: ( MULT e2= compound_expression_dot | DIV e3= compound_expression_dot | MOD e4= compound_expression_dot )*
            loop16:
            do {
                int alt16=4;
                switch ( input.LA(1) ) {
                case MULT:
                    {
                    alt16=1;
                    }
                    break;
                case DIV:
                    {
                    alt16=2;
                    }
                    break;
                case MOD:
                    {
                    alt16=3;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:303:4: MULT e2= compound_expression_dot
            	    {
            	    match(input,MULT,FOLLOW_MULT_in_compound_expression_mult_div1435); 

            	    pushFollow(FOLLOW_compound_expression_dot_in_compound_expression_mult_div1440);
            	    e2=compound_expression_dot();

            	    state._fsp--;


            	    result = "multiply.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;
            	case 2 :
            	    // /home/nickpeck/Humble/humble.g:304:6: DIV e3= compound_expression_dot
            	    {
            	    match(input,DIV,FOLLOW_DIV_in_compound_expression_mult_div1449); 

            	    pushFollow(FOLLOW_compound_expression_dot_in_compound_expression_mult_div1454);
            	    e3=compound_expression_dot();

            	    state._fsp--;


            	    result = "divide.call(" + result + ", " + e3.toString() + ")";

            	    }
            	    break;
            	case 3 :
            	    // /home/nickpeck/Humble/humble.g:305:6: MOD e4= compound_expression_dot
            	    {
            	    match(input,MOD,FOLLOW_MOD_in_compound_expression_mult_div1463); 

            	    pushFollow(FOLLOW_compound_expression_dot_in_compound_expression_mult_div1467);
            	    e4=compound_expression_dot();

            	    state._fsp--;


            	    result = "modulus.call(" + result + ", " + e4.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_mult_div"



    // $ANTLR start "compound_expression_plus_minus"
    // /home/nickpeck/Humble/humble.g:310:1: compound_expression_plus_minus returns [String result] : e= compound_expression_mult_div ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )* ;
    public final String compound_expression_plus_minus() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;

        String e3 =null;


        try {
            // /home/nickpeck/Humble/humble.g:311:2: (e= compound_expression_mult_div ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )* )
            // /home/nickpeck/Humble/humble.g:312:3: e= compound_expression_mult_div ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )*
            {
            pushFollow(FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1496);
            e=compound_expression_mult_div();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/Humble/humble.g:313:3: ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==PLUS) ) {
                    alt17=1;
                }
                else if ( (LA17_0==MINUS) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:314:4: PLUS e2= compound_expression_mult_div
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_compound_expression_plus_minus1507); 

            	    pushFollow(FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1511);
            	    e2=compound_expression_mult_div();

            	    state._fsp--;


            	    result = "plus.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;
            	case 2 :
            	    // /home/nickpeck/Humble/humble.g:315:6: MINUS e3= compound_expression_mult_div
            	    {
            	    match(input,MINUS,FOLLOW_MINUS_in_compound_expression_plus_minus1520); 

            	    pushFollow(FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1524);
            	    e3=compound_expression_mult_div();

            	    state._fsp--;


            	    result = "minus.call(" + result + ", " + e3.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_plus_minus"



    // $ANTLR start "compound_expression_is"
    // /home/nickpeck/Humble/humble.g:319:1: compound_expression_is returns [String result] : e= compound_expression_plus_minus ( IS e2= compound_expression_plus_minus )* ;
    public final String compound_expression_is() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:320:2: (e= compound_expression_plus_minus ( IS e2= compound_expression_plus_minus )* )
            // /home/nickpeck/Humble/humble.g:321:3: e= compound_expression_plus_minus ( IS e2= compound_expression_plus_minus )*
            {
            pushFollow(FOLLOW_compound_expression_plus_minus_in_compound_expression_is1552);
            e=compound_expression_plus_minus();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/Humble/humble.g:322:3: ( IS e2= compound_expression_plus_minus )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:323:4: IS e2= compound_expression_plus_minus
            	    {
            	    match(input,IS,FOLLOW_IS_in_compound_expression_is1563); 

            	    pushFollow(FOLLOW_compound_expression_plus_minus_in_compound_expression_is1567);
            	    e2=compound_expression_plus_minus();

            	    state._fsp--;


            	    result = "equals.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_is"



    // $ANTLR start "compound_expression_not"
    // /home/nickpeck/Humble/humble.g:327:1: compound_expression_not returns [String result] : (e= compound_expression_is | NOT e2= compound_expression_is );
    public final String compound_expression_not() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:328:2: (e= compound_expression_is | NOT e2= compound_expression_is )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==BOOL||LA19_0==IDENT||LA19_0==LAB||(LA19_0 >= LPAREN && LA19_0 <= LSB)||LA19_0==NEW||LA19_0==NUMBER||LA19_0==STR) ) {
                alt19=1;
            }
            else if ( (LA19_0==NOT) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:329:3: e= compound_expression_is
                    {
                    pushFollow(FOLLOW_compound_expression_is_in_compound_expression_not1595);
                    e=compound_expression_is();

                    state._fsp--;


                    result = e.toString();

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:331:4: NOT e2= compound_expression_is
                    {
                    match(input,NOT,FOLLOW_NOT_in_compound_expression_not1605); 

                    pushFollow(FOLLOW_compound_expression_is_in_compound_expression_not1610);
                    e2=compound_expression_is();

                    state._fsp--;


                    result = "not.call(" + e2.toString() + ")";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_not"



    // $ANTLR start "compound_expression_and"
    // /home/nickpeck/Humble/humble.g:334:1: compound_expression_and returns [String result] : e= compound_expression_not ( AND e2= compound_expression_not )* ;
    public final String compound_expression_and() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:335:2: (e= compound_expression_not ( AND e2= compound_expression_not )* )
            // /home/nickpeck/Humble/humble.g:336:3: e= compound_expression_not ( AND e2= compound_expression_not )*
            {
            pushFollow(FOLLOW_compound_expression_not_in_compound_expression_and1632);
            e=compound_expression_not();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/Humble/humble.g:337:3: ( AND e2= compound_expression_not )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==AND) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:338:4: AND e2= compound_expression_not
            	    {
            	    match(input,AND,FOLLOW_AND_in_compound_expression_and1643); 

            	    pushFollow(FOLLOW_compound_expression_not_in_compound_expression_and1648);
            	    e2=compound_expression_not();

            	    state._fsp--;


            	    result = "and.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_and"



    // $ANTLR start "compound_expression_or"
    // /home/nickpeck/Humble/humble.g:342:1: compound_expression_or returns [String result] : e= compound_expression_and ( OR e2= compound_expression_and )* ;
    public final String compound_expression_or() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:343:2: (e= compound_expression_and ( OR e2= compound_expression_and )* )
            // /home/nickpeck/Humble/humble.g:344:3: e= compound_expression_and ( OR e2= compound_expression_and )*
            {
            pushFollow(FOLLOW_compound_expression_and_in_compound_expression_or1675);
            e=compound_expression_and();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/Humble/humble.g:345:3: ( OR e2= compound_expression_and )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==OR) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:346:4: OR e2= compound_expression_and
            	    {
            	    match(input,OR,FOLLOW_OR_in_compound_expression_or1686); 

            	    pushFollow(FOLLOW_compound_expression_and_in_compound_expression_or1691);
            	    e2=compound_expression_and();

            	    state._fsp--;


            	    result = "or.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression_or"



    // $ANTLR start "compound_expression"
    // /home/nickpeck/Humble/humble.g:359:1: compound_expression returns [String result] : (e= compound_expression_or |c= conditional );
    public final String compound_expression() throws RecognitionException {
        String result = null;


        String e =null;

        StringBuilder c =null;


        try {
            // /home/nickpeck/Humble/humble.g:360:2: (e= compound_expression_or |c= conditional )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==BOOL||LA22_0==IDENT||LA22_0==LAB||(LA22_0 >= LPAREN && LA22_0 <= LSB)||(LA22_0 >= NEW && LA22_0 <= NUMBER)||LA22_0==STR) ) {
                alt22=1;
            }
            else if ( (LA22_0==IF) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:361:2: e= compound_expression_or
                    {
                    pushFollow(FOLLOW_compound_expression_or_in_compound_expression1723);
                    e=compound_expression_or();

                    state._fsp--;


                    result = e.toString();

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:362:4: c= conditional
                    {
                    pushFollow(FOLLOW_conditional_in_compound_expression1732);
                    c=conditional();

                    state._fsp--;


                    result = c.toString();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "compound_expression"



    // $ANTLR start "conditional"
    // /home/nickpeck/Humble/humble.g:366:1: conditional returns [StringBuilder result] : i= IF e2= compound_expression THEN e3= compound_expression ELSE e4= compound_expression ;
    public final StringBuilder conditional() throws RecognitionException {
        StringBuilder result = null;


        Token i=null;
        String e2 =null;

        String e3 =null;

        String e4 =null;


        try {
            // /home/nickpeck/Humble/humble.g:367:2: (i= IF e2= compound_expression THEN e3= compound_expression ELSE e4= compound_expression )
            // /home/nickpeck/Humble/humble.g:368:4: i= IF e2= compound_expression THEN e3= compound_expression ELSE e4= compound_expression
            {
            i=(Token)match(input,IF,FOLLOW_IF_in_conditional1756); 

            pushFollow(FOLLOW_compound_expression_in_conditional1760);
            e2=compound_expression();

            state._fsp--;


            match(input,THEN,FOLLOW_THEN_in_conditional1762); 

            pushFollow(FOLLOW_compound_expression_in_conditional1766);
            e3=compound_expression();

            state._fsp--;


            match(input,ELSE,FOLLOW_ELSE_in_conditional1768); 

            pushFollow(FOLLOW_compound_expression_in_conditional1772);
            e4=compound_expression();

            state._fsp--;


            result = new StringBuilder();

            result.append(" new Conditional() {");

            result.append("	@Override");

            result.append("	public final _Boolean condition() throws HumbleRuntimeException {");

            result.append("		return (_Boolean) yield(" + e2.toString() + ");");

            result.append("	}");

            result.append("	@Override");

            result.append("	public final Callable onIf() {");

            result.append("		return " + e3.toString() + ";");

            result.append("	}");

            result.append("	@Override");

            result.append("	public final Callable onElse() {");

            result.append("		return " + e4.toString() + ";");

            result.append("	}");

            result.append("}.call()");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "conditional"



    // $ANTLR start "lambda"
    // /home/nickpeck/Humble/humble.g:392:1: lambda returns [StringBuilder result] : ( LAMBDA LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )? a= AS (e= compound_expression |l= lambda ) ;
    public final StringBuilder lambda() throws RecognitionException {
        StringBuilder result = null;


        Token tp=null;
        Token i1=null;
        Token i11=null;
        Token i2=null;
        Token a=null;
        LinkedList<String> d1 =null;

        LinkedList<String> ls1 =null;

        LinkedList<String> d2 =null;

        LinkedList<String> ls2 =null;

        String e =null;

        StringBuilder l =null;


        try {
            // /home/nickpeck/Humble/humble.g:393:2: ( ( LAMBDA LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )? a= AS (e= compound_expression |l= lambda ) )
            // /home/nickpeck/Humble/humble.g:394:3: ( LAMBDA LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )? a= AS (e= compound_expression |l= lambda )
            {
            result = new StringBuilder();

            StringBuilder args = new StringBuilder();

            int argIndex=0;

            // /home/nickpeck/Humble/humble.g:398:3: ( LAMBDA LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LAMBDA) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:399:4: LAMBDA LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN
                    {
                    match(input,LAMBDA,FOLLOW_LAMBDA_in_lambda1917); 

                    match(input,LPAREN,FOLLOW_LPAREN_in_lambda1925); 

                    // /home/nickpeck/Humble/humble.g:402:4: ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==IDENT||LA26_0==LAB) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /home/nickpeck/Humble/humble.g:403:5: ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                            {
                            // /home/nickpeck/Humble/humble.g:403:5: ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice )
                            int alt23=4;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0==LAB) ) {
                                alt23=1;
                            }
                            else if ( (LA23_0==IDENT) ) {
                                int LA23_2 = input.LA(2);

                                if ( (LA23_2==COMMA||LA23_2==RPAREN) ) {
                                    alt23=2;
                                }
                                else if ( (LA23_2==DEREF) ) {
                                    int LA23_4 = input.LA(3);

                                    if ( (LA23_4==LSB) ) {
                                        int LA23_5 = input.LA(4);

                                        if ( (LA23_5==IDENT) ) {
                                            int LA23_6 = input.LA(5);

                                            if ( (LA23_6==COLON) ) {
                                                alt23=4;
                                            }
                                            else if ( (LA23_6==COMMA||LA23_6==RSB) ) {
                                                alt23=3;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 23, 6, input);

                                                throw nvae;

                                            }
                                        }
                                        else if ( (LA23_5==RSB) ) {
                                            alt23=3;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 23, 5, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 23, 4, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 23, 2, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 23, 0, input);

                                throw nvae;

                            }
                            switch (alt23) {
                                case 1 :
                                    // /home/nickpeck/Humble/humble.g:404:6: ( LAB tp= IDENT RAB i1= IDENT )
                                    {
                                    // /home/nickpeck/Humble/humble.g:404:6: ( LAB tp= IDENT RAB i1= IDENT )
                                    // /home/nickpeck/Humble/humble.g:405:7: LAB tp= IDENT RAB i1= IDENT
                                    {
                                    match(input,LAB,FOLLOW_LAB_in_lambda1951); 

                                    tp=(Token)match(input,IDENT,FOLLOW_IDENT_in_lambda1955); 

                                    match(input,RAB,FOLLOW_RAB_in_lambda1957); 

                                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_lambda1961); 

                                    args.append(" final " + tp.getText() + " ");

                                    args.append(i1.getText());

                                    args.append(" = (" + tp.getText() + ")args[" + argIndex + "];");

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /home/nickpeck/Humble/humble.g:410:6: (i11= IDENT )
                                    {
                                    // /home/nickpeck/Humble/humble.g:410:6: (i11= IDENT )
                                    // /home/nickpeck/Humble/humble.g:411:7: i11= IDENT
                                    {
                                    i11=(Token)match(input,IDENT,FOLLOW_IDENT_in_lambda2010); 

                                    args.append(" final Callable ");

                                    args.append(i11.getText());

                                    args.append(" = args[" + argIndex + "];");

                                    }


                                    }
                                    break;
                                case 3 :
                                    // /home/nickpeck/Humble/humble.g:415:8: d1= dereference
                                    {
                                    pushFollow(FOLLOW_dereference_in_lambda2046);
                                    d1=dereference();

                                    state._fsp--;



                                    						args.append(" final Callable " + d1.get(0) + " = ((_List)args[0]);");
                                    						for(int index=1;index<d1.size();index++) {
                                    							args.append(" final Callable " + d1.get(index) + " = ((_List)args[" + argIndex + "]).get(" + (index-1) + ");");
                                    						}
                                    					

                                    }
                                    break;
                                case 4 :
                                    // /home/nickpeck/Humble/humble.g:422:8: ls1= list_slice
                                    {
                                    pushFollow(FOLLOW_list_slice_in_lambda2064);
                                    ls1=list_slice();

                                    state._fsp--;



                                    						args.append(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
                                    						args.append(" final Callable " + ls1.get(1) + " = list_head.call(((_List)args[0]));");
                                    						args.append(" final Callable " + ls1.get(2) + " = list_tail.call(((_List)args[0]));");
                                    					

                                    }
                                    break;

                            }


                            // /home/nickpeck/Humble/humble.g:430:5: ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==COMMA) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // /home/nickpeck/Humble/humble.g:431:6: COMMA (i2= IDENT |d2= dereference |ls2= list_slice )
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_lambda2095); 

                            	    argIndex ++;

                            	    // /home/nickpeck/Humble/humble.g:432:6: (i2= IDENT |d2= dereference |ls2= list_slice )
                            	    int alt24=3;
                            	    int LA24_0 = input.LA(1);

                            	    if ( (LA24_0==IDENT) ) {
                            	        int LA24_1 = input.LA(2);

                            	        if ( (LA24_1==COMMA||LA24_1==RPAREN) ) {
                            	            alt24=1;
                            	        }
                            	        else if ( (LA24_1==DEREF) ) {
                            	            int LA24_3 = input.LA(3);

                            	            if ( (LA24_3==LSB) ) {
                            	                int LA24_4 = input.LA(4);

                            	                if ( (LA24_4==IDENT) ) {
                            	                    int LA24_5 = input.LA(5);

                            	                    if ( (LA24_5==COLON) ) {
                            	                        alt24=3;
                            	                    }
                            	                    else if ( (LA24_5==COMMA||LA24_5==RSB) ) {
                            	                        alt24=2;
                            	                    }
                            	                    else {
                            	                        NoViableAltException nvae =
                            	                            new NoViableAltException("", 24, 5, input);

                            	                        throw nvae;

                            	                    }
                            	                }
                            	                else if ( (LA24_4==RSB) ) {
                            	                    alt24=2;
                            	                }
                            	                else {
                            	                    NoViableAltException nvae =
                            	                        new NoViableAltException("", 24, 4, input);

                            	                    throw nvae;

                            	                }
                            	            }
                            	            else {
                            	                NoViableAltException nvae =
                            	                    new NoViableAltException("", 24, 3, input);

                            	                throw nvae;

                            	            }
                            	        }
                            	        else {
                            	            NoViableAltException nvae =
                            	                new NoViableAltException("", 24, 1, input);

                            	            throw nvae;

                            	        }
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 24, 0, input);

                            	        throw nvae;

                            	    }
                            	    switch (alt24) {
                            	        case 1 :
                            	            // /home/nickpeck/Humble/humble.g:432:7: i2= IDENT
                            	            {
                            	            args.append(",");

                            	            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_lambda2114); 

                            	            args.append(" final Callable ");

                            	            args.append(i2.getText());

                            	            args.append(" = args[" + argIndex + "];");

                            	            }
                            	            break;
                            	        case 2 :
                            	            // /home/nickpeck/Humble/humble.g:436:7: d2= dereference
                            	            {
                            	            pushFollow(FOLLOW_dereference_in_lambda2140);
                            	            d2=dereference();

                            	            state._fsp--;



                            	            						args.append(" final Callable " + d2.get(0) + " = ((_List)args[" + argIndex + "]);");
                            	            						for(int index2=1;index2<d2.size();index2++) {
                            	            							args.append(" final Callable " + d2.get(index2) + " = ((_List)args[" + argIndex + "]).get(" + (index2-1) + ");");
                            	            						}
                            	            					

                            	            }
                            	            break;
                            	        case 3 :
                            	            // /home/nickpeck/Humble/humble.g:443:8: ls2= list_slice
                            	            {
                            	            pushFollow(FOLLOW_list_slice_in_lambda2158);
                            	            ls2=list_slice();

                            	            state._fsp--;



                            	            						args.append(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
                            	            						args.append(" final Callable " + ls2.get(1) + " = list_head.call(((_List)args[" + argIndex + "]));");
                            	            						args.append(" final Callable " + ls2.get(2) + " = list_tail.call(((_List)args[" + argIndex + "]));");
                            	            					

                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_lambda2190); 

                    }
                    break;

            }


            a=(Token)match(input,AS,FOLLOW_AS_in_lambda2206); 

            // /home/nickpeck/Humble/humble.g:457:3: (e= compound_expression |l= lambda )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==BOOL||(LA28_0 >= IDENT && LA28_0 <= IF)||LA28_0==LAB||(LA28_0 >= LPAREN && LA28_0 <= LSB)||(LA28_0 >= NEW && LA28_0 <= NUMBER)||LA28_0==STR) ) {
                alt28=1;
            }
            else if ( (LA28_0==AS||LA28_0==LAMBDA) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:458:4: e= compound_expression
                    {
                    pushFollow(FOLLOW_compound_expression_in_lambda2218);
                    e=compound_expression();

                    state._fsp--;



                    				result.append(" new Lambda() {");
                    				result.append("	@Override");
                    				result.append("	protected final Callable evaluate(Callable... args) {");
                    				result.append("		" + args.toString());
                    				result.append("		return " + e.toString() + ";");
                    				result.append("	}");
                    				result.append("}");
                    			

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:469:6: l= lambda
                    {
                    pushFollow(FOLLOW_lambda_in_lambda2236);
                    l=lambda();

                    state._fsp--;


                    	
                    				result.append(" new Lambda() {");
                    				result.append("	@Override");
                    				result.append("	protected final Callable evaluate(Callable... args) {");
                    				result.append("		" + args.toString());
                    				result.append("		return " + l.toString() + ";");
                    				result.append("	}");
                    				result.append("}");
                    			

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "lambda"



    // $ANTLR start "statement"
    // /home/nickpeck/Humble/humble.g:485:1: statement returns [StringBuilder result] : ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* ) ;
    public final StringBuilder statement() throws RecognitionException {
        StringBuilder result = null;


        String e1 =null;

        StringBuilder l1 =null;

        String e2 =null;

        StringBuilder l2 =null;


        try {
            // /home/nickpeck/Humble/humble.g:486:2: ( ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* ) )
            // /home/nickpeck/Humble/humble.g:486:4: ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* )
            {
            result = new StringBuilder();

            // /home/nickpeck/Humble/humble.g:487:3: ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* )
            // /home/nickpeck/Humble/humble.g:488:4: (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )*
            {
            // /home/nickpeck/Humble/humble.g:488:4: (e1= compound_expression |l1= lambda )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==BOOL||(LA29_0 >= IDENT && LA29_0 <= IF)||LA29_0==LAB||(LA29_0 >= LPAREN && LA29_0 <= LSB)||(LA29_0 >= NEW && LA29_0 <= NUMBER)||LA29_0==STR) ) {
                alt29=1;
            }
            else if ( (LA29_0==AS||LA29_0==LAMBDA) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:489:5: e1= compound_expression
                    {
                    pushFollow(FOLLOW_compound_expression_in_statement2283);
                    e1=compound_expression();

                    state._fsp--;


                    result.append(e1.toString());

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:491:7: l1= lambda
                    {
                    pushFollow(FOLLOW_lambda_in_statement2299);
                    l1=lambda();

                    state._fsp--;


                    result.append(l1.toString());

                    }
                    break;

            }


            // /home/nickpeck/Humble/humble.g:494:4: ( BINDS e2= compound_expression | BINDS l2= lambda )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==BINDS) ) {
                    int LA30_2 = input.LA(2);

                    if ( (LA30_2==BOOL||(LA30_2 >= IDENT && LA30_2 <= IF)||LA30_2==LAB||(LA30_2 >= LPAREN && LA30_2 <= LSB)||(LA30_2 >= NEW && LA30_2 <= NUMBER)||LA30_2==STR) ) {
                        alt30=1;
                    }
                    else if ( (LA30_2==AS||LA30_2==LAMBDA) ) {
                        alt30=2;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:495:5: BINDS e2= compound_expression
            	    {
            	    match(input,BINDS,FOLLOW_BINDS_in_statement2322); 

            	    pushFollow(FOLLOW_compound_expression_in_statement2326);
            	    e2=compound_expression();

            	    state._fsp--;


            	    result.append( ".bindTo(new Lambda() {");

            	    result.append("	@Override");

            	    result.append("	protected final Callable evaluate(Callable... args) {");

            	    result.append("		return " + e2.toString() + ".call(args);");

            	    result.append("	}");

            	    result.append("})");

            	    }
            	    break;
            	case 2 :
            	    // /home/nickpeck/Humble/humble.g:502:7: BINDS l2= lambda
            	    {
            	    match(input,BINDS,FOLLOW_BINDS_in_statement2373); 

            	    pushFollow(FOLLOW_lambda_in_statement2377);
            	    l2=lambda();

            	    state._fsp--;


            	    result.append( ".bindTo(" + l2.toString() + ")");

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "function"
    // /home/nickpeck/Humble/humble.g:510:1: function returns [StringBuilder result] : DEF i= IDENT LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN AS (s1= statement ) EOL ;
    public final StringBuilder function() throws RecognitionException {
        StringBuilder result = null;


        Token i=null;
        Token tp=null;
        Token i1=null;
        Token i11=null;
        Token i2=null;
        LinkedList<String> d1 =null;

        LinkedList<String> ls1 =null;

        LinkedList<String> d2 =null;

        LinkedList<String> ls2 =null;

        StringBuilder s1 =null;


        try {
            // /home/nickpeck/Humble/humble.g:511:2: ( DEF i= IDENT LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN AS (s1= statement ) EOL )
            // /home/nickpeck/Humble/humble.g:512:3: DEF i= IDENT LPAREN ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN AS (s1= statement ) EOL
            {
            result = new StringBuilder();

            LinkedList<String> args = new LinkedList<String>();

            match(input,DEF,FOLLOW_DEF_in_function2431); 

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2435); 

            int argIndex=0;

            match(input,LPAREN,FOLLOW_LPAREN_in_function2445); 

            // /home/nickpeck/Humble/humble.g:518:3: ( ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDENT||LA34_0==LAB) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:519:4: ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                    {
                    // /home/nickpeck/Humble/humble.g:519:4: ( ( LAB tp= IDENT RAB i1= IDENT ) | (i11= IDENT ) |d1= dereference |ls1= list_slice )
                    int alt31=4;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==LAB) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==IDENT) ) {
                        int LA31_2 = input.LA(2);

                        if ( (LA31_2==COMMA||LA31_2==RPAREN) ) {
                            alt31=2;
                        }
                        else if ( (LA31_2==DEREF) ) {
                            int LA31_4 = input.LA(3);

                            if ( (LA31_4==LSB) ) {
                                int LA31_5 = input.LA(4);

                                if ( (LA31_5==IDENT) ) {
                                    int LA31_6 = input.LA(5);

                                    if ( (LA31_6==COLON) ) {
                                        alt31=4;
                                    }
                                    else if ( (LA31_6==COMMA||LA31_6==RSB) ) {
                                        alt31=3;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 31, 6, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA31_5==RSB) ) {
                                    alt31=3;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 31, 5, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 31, 4, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 31, 2, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;

                    }
                    switch (alt31) {
                        case 1 :
                            // /home/nickpeck/Humble/humble.g:523:5: ( LAB tp= IDENT RAB i1= IDENT )
                            {
                            // /home/nickpeck/Humble/humble.g:523:5: ( LAB tp= IDENT RAB i1= IDENT )
                            // /home/nickpeck/Humble/humble.g:524:6: LAB tp= IDENT RAB i1= IDENT
                            {
                            match(input,LAB,FOLLOW_LAB_in_function2482); 

                            tp=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2486); 

                            match(input,RAB,FOLLOW_RAB_in_function2488); 

                            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2492); 

                            args.add(" final " + tp.getText() + " ");

                            args.add(i1.getText());

                            args.add(" = (" + tp.getText() + ")args[" + argIndex + "];");

                            }


                            }
                            break;
                        case 2 :
                            // /home/nickpeck/Humble/humble.g:529:5: (i11= IDENT )
                            {
                            // /home/nickpeck/Humble/humble.g:529:5: (i11= IDENT )
                            // /home/nickpeck/Humble/humble.g:530:6: i11= IDENT
                            {
                            i11=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2535); 

                            args.add(" final Callable ");

                            args.add(i11.getText());

                            args.add(" = args[" + argIndex + "];");

                            }


                            }
                            break;
                        case 3 :
                            // /home/nickpeck/Humble/humble.g:534:7: d1= dereference
                            {
                            pushFollow(FOLLOW_dereference_in_function2567);
                            d1=dereference();

                            state._fsp--;



                            					args.add(" final Callable " + d1.get(0) + " = ((_List)args[0]);");
                            					for(int index=1;index<d1.size();index++) {
                            						args.add(" final Callable " + d1.get(index) + " = ((_List)args[0]).get(" + (index-1) + ");");
                            					}
                            				

                            }
                            break;
                        case 4 :
                            // /home/nickpeck/Humble/humble.g:541:7: ls1= list_slice
                            {
                            pushFollow(FOLLOW_list_slice_in_function2588);
                            ls1=list_slice();

                            state._fsp--;



                            					args.add(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
                            					args.add(" final Callable " + ls1.get(1) + " = list_head.call(((_List)args[0]));");
                            					args.add(" final Callable " + ls1.get(2) + " = list_tail.call(((_List)args[0]));");
                            				

                            }
                            break;

                    }


                    // /home/nickpeck/Humble/humble.g:549:4: ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==COMMA) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:550:5: COMMA (i2= IDENT |d2= dereference |ls2= list_slice )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_function2615); 

                    	    argIndex ++;

                    	    // /home/nickpeck/Humble/humble.g:551:5: (i2= IDENT |d2= dereference |ls2= list_slice )
                    	    int alt32=3;
                    	    int LA32_0 = input.LA(1);

                    	    if ( (LA32_0==IDENT) ) {
                    	        int LA32_1 = input.LA(2);

                    	        if ( (LA32_1==COMMA||LA32_1==RPAREN) ) {
                    	            alt32=1;
                    	        }
                    	        else if ( (LA32_1==DEREF) ) {
                    	            int LA32_3 = input.LA(3);

                    	            if ( (LA32_3==LSB) ) {
                    	                int LA32_4 = input.LA(4);

                    	                if ( (LA32_4==IDENT) ) {
                    	                    int LA32_5 = input.LA(5);

                    	                    if ( (LA32_5==COLON) ) {
                    	                        alt32=3;
                    	                    }
                    	                    else if ( (LA32_5==COMMA||LA32_5==RSB) ) {
                    	                        alt32=2;
                    	                    }
                    	                    else {
                    	                        NoViableAltException nvae =
                    	                            new NoViableAltException("", 32, 5, input);

                    	                        throw nvae;

                    	                    }
                    	                }
                    	                else if ( (LA32_4==RSB) ) {
                    	                    alt32=2;
                    	                }
                    	                else {
                    	                    NoViableAltException nvae =
                    	                        new NoViableAltException("", 32, 4, input);

                    	                    throw nvae;

                    	                }
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 32, 3, input);

                    	                throw nvae;

                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 32, 1, input);

                    	            throw nvae;

                    	        }
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 32, 0, input);

                    	        throw nvae;

                    	    }
                    	    switch (alt32) {
                    	        case 1 :
                    	            // /home/nickpeck/Humble/humble.g:551:6: i2= IDENT
                    	            {
                    	            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2626); 

                    	            args.add(" final Callable " + i2.getText() + " = args[" + argIndex + "];");

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /home/nickpeck/Humble/humble.g:554:7: d2= dereference
                    	            {
                    	            pushFollow(FOLLOW_dereference_in_function2648);
                    	            d2=dereference();

                    	            state._fsp--;



                    	            					args.add(" final Callable " + d2.get(0) + " = ((_List)args[" + argIndex + "]);");
                    	            					for(int index2=1;index2<d2.size();index2++) {
                    	            						args.add(" final Callable " + d2.get(index2) + " = ((_List)args[" + argIndex + "]).get(" + (index2-1) + ");");
                    	            					}
                    	            				

                    	            }
                    	            break;
                    	        case 3 :
                    	            // /home/nickpeck/Humble/humble.g:561:7: ls2= list_slice
                    	            {
                    	            pushFollow(FOLLOW_list_slice_in_function2664);
                    	            ls2=list_slice();

                    	            state._fsp--;



                    	            					args.add(" final Callable " + ls2.get(0) + " = ((_List)args[" + argIndex + "]);");
                    	            					args.add(" final Callable " + ls2.get(1) + " = list_head.call(((_List)args[" + argIndex + "]));");
                    	            					args.add(" final Callable " + ls2.get(2) + " = list_tail.call(((_List)args[" + argIndex + "]));");
                    	            				

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_function2696); 

            result.append("public final static Lambda " + i.getText() + " = new Lambda() {");

            result.append("		@Override");

            result.append("		protected final Callable evaluate(Callable... args) {");

            match(input,AS,FOLLOW_AS_in_function2722); 

            // /home/nickpeck/Humble/humble.g:579:3: (s1= statement )
            // /home/nickpeck/Humble/humble.g:581:4: s1= statement
            {
            pushFollow(FOLLOW_statement_in_function2737);
            s1=statement();

            state._fsp--;



            	
            				for(int i3=0;i3<args.size();i3++) {
            					result.append(args.get(i3));
            				}
            				result.append("			return " + s1.toString() + ";");
            			

            }


            result.append("		}");

            result.append("	}");

            match(input,EOL,FOLLOW_EOL_in_function2778); 

            result.append(";");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "function"



    // $ANTLR start "typedef"
    // /home/nickpeck/Humble/humble.g:613:1: typedef returns [StringBuilder result] : DEF LAB id= IDENT RAB LPAREN ( (i1= IDENT ) ( COMMA (i2= IDENT ) )* )? RPAREN AS (f= function )* EOL ;
    public final StringBuilder typedef() throws RecognitionException {
        StringBuilder result = null;


        Token id=null;
        Token i1=null;
        Token i2=null;
        StringBuilder f =null;


        try {
            // /home/nickpeck/Humble/humble.g:614:2: ( DEF LAB id= IDENT RAB LPAREN ( (i1= IDENT ) ( COMMA (i2= IDENT ) )* )? RPAREN AS (f= function )* EOL )
            // /home/nickpeck/Humble/humble.g:615:3: DEF LAB id= IDENT RAB LPAREN ( (i1= IDENT ) ( COMMA (i2= IDENT ) )* )? RPAREN AS (f= function )* EOL
            {
            result = new StringBuilder();

            match(input,DEF,FOLLOW_DEF_in_typedef2804); 

            match(input,LAB,FOLLOW_LAB_in_typedef2806); 

            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_typedef2810); 

            match(input,RAB,FOLLOW_RAB_in_typedef2812); 

            LinkedList<String> args = new LinkedList();

            int argIndex = 0;

            match(input,LPAREN,FOLLOW_LPAREN_in_typedef2833); 

            // /home/nickpeck/Humble/humble.g:623:3: ( (i1= IDENT ) ( COMMA (i2= IDENT ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDENT) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:624:4: (i1= IDENT ) ( COMMA (i2= IDENT ) )*
                    {
                    // /home/nickpeck/Humble/humble.g:624:4: (i1= IDENT )
                    // /home/nickpeck/Humble/humble.g:625:5: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_typedef2850); 

                    args.add(i1.getText());

                    }


                    // /home/nickpeck/Humble/humble.g:628:4: ( COMMA (i2= IDENT ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==COMMA) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:629:5: COMMA (i2= IDENT )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_typedef2873); 

                    	    argIndex ++;

                    	    // /home/nickpeck/Humble/humble.g:630:5: (i2= IDENT )
                    	    // /home/nickpeck/Humble/humble.g:630:6: i2= IDENT
                    	    {
                    	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_typedef2884); 

                    	    args.add(i2.getText());

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_typedef2918); 


            			for(int i=0;i<args.size();i++) {		
            				result.append(" private static Callable " + args.get(i) + ";");
            			}
            		

            result.append("	public " + id.getText() + "(Callable... args){");


            			for(int i=0;i<args.size();i++) {
            				{result.append(args.get(i) + " = args[" + i + "];");}
            			}
            		

            result.append("}");

            match(input,AS,FOLLOW_AS_in_typedef2947); 

            // /home/nickpeck/Humble/humble.g:654:3: (f= function )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==DEF) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:654:4: f= function
            	    {
            	    pushFollow(FOLLOW_function_in_typedef2957);
            	    f=function();

            	    state._fsp--;


            	    result.append(f.toString());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            match(input,EOL,FOLLOW_EOL_in_typedef2975); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "typedef"



    // $ANTLR start "module"
    // /home/nickpeck/Humble/humble.g:662:1: module returns [StringBuilder result] :p= package_statement (i= import_statment )* (es= extends_statement )? (t= typedef | ( (f= function |s= statement ( EOL ) )* ) ) EOF ;
    public final StringBuilder module() throws RecognitionException {
        StringBuilder result = null;


        String p =null;

        String i =null;

        String es =null;

        StringBuilder t =null;

        StringBuilder f =null;

        StringBuilder s =null;


        try {
            // /home/nickpeck/Humble/humble.g:663:2: (p= package_statement (i= import_statment )* (es= extends_statement )? (t= typedef | ( (f= function |s= statement ( EOL ) )* ) ) EOF )
            // /home/nickpeck/Humble/humble.g:664:3: p= package_statement (i= import_statment )* (es= extends_statement )? (t= typedef | ( (f= function |s= statement ( EOL ) )* ) ) EOF
            {
            result = new StringBuilder();

            pushFollow(FOLLOW_package_statement_in_module3006);
            p=package_statement();

            state._fsp--;


            result.append(p.toString());

            result.append("import humble.runtime.*;");

            result.append("import humble.primitives.*;");

            result.append("import humble.runtime.HumbleRuntimeException;");

            // /home/nickpeck/Humble/humble.g:671:3: (i= import_statment )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==IMPORT) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/nickpeck/Humble/humble.g:672:4: i= import_statment
            	    {
            	    pushFollow(FOLLOW_import_statment_in_module3034);
            	    i=import_statment();

            	    state._fsp--;


            	    result.append(i.toString());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            String _extends=" extends Module ";

            // /home/nickpeck/Humble/humble.g:677:3: (es= extends_statement )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==EXTENDS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:678:4: es= extends_statement
                    {
                    pushFollow(FOLLOW_extends_statement_in_module3063);
                    es=extends_statement();

                    state._fsp--;


                    _extends = es.toString();

                    }
                    break;

            }


            result.append("public class " + getModuleName() + " " + _extends + " {");

            StringBuilder statements = new StringBuilder();

            // /home/nickpeck/Humble/humble.g:684:3: (t= typedef | ( (f= function |s= statement ( EOL ) )* ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==DEF) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==LAB) ) {
                    alt41=1;
                }
                else if ( (LA41_1==IDENT) ) {
                    alt41=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA41_0==EOF||LA41_0==AS||LA41_0==BOOL||(LA41_0 >= IDENT && LA41_0 <= IF)||(LA41_0 >= LAB && LA41_0 <= LAMBDA)||(LA41_0 >= LPAREN && LA41_0 <= LSB)||(LA41_0 >= NEW && LA41_0 <= NUMBER)||LA41_0==STR) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /home/nickpeck/Humble/humble.g:685:4: t= typedef
                    {
                    pushFollow(FOLLOW_typedef_in_module3095);
                    t=typedef();

                    state._fsp--;


                    result.append(t.toString());

                    }
                    break;
                case 2 :
                    // /home/nickpeck/Humble/humble.g:687:4: ( (f= function |s= statement ( EOL ) )* )
                    {
                    // /home/nickpeck/Humble/humble.g:687:4: ( (f= function |s= statement ( EOL ) )* )
                    // /home/nickpeck/Humble/humble.g:688:5: (f= function |s= statement ( EOL ) )*
                    {
                    statements.append("public static void main(String[] args) throws HumbleRuntimeException{");

                    // /home/nickpeck/Humble/humble.g:689:5: (f= function |s= statement ( EOL ) )*
                    loop40:
                    do {
                        int alt40=3;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==DEF) ) {
                            alt40=1;
                        }
                        else if ( (LA40_0==AS||LA40_0==BOOL||(LA40_0 >= IDENT && LA40_0 <= IF)||(LA40_0 >= LAB && LA40_0 <= LAMBDA)||(LA40_0 >= LPAREN && LA40_0 <= LSB)||(LA40_0 >= NEW && LA40_0 <= NUMBER)||LA40_0==STR) ) {
                            alt40=2;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/nickpeck/Humble/humble.g:690:6: f= function
                    	    {
                    	    pushFollow(FOLLOW_function_in_module3130);
                    	    f=function();

                    	    state._fsp--;


                    	    result.append(f.toString());

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/nickpeck/Humble/humble.g:691:8: s= statement ( EOL )
                    	    {
                    	    pushFollow(FOLLOW_statement_in_module3143);
                    	    s=statement();

                    	    state._fsp--;


                    	    // /home/nickpeck/Humble/humble.g:692:6: ( EOL )
                    	    // /home/nickpeck/Humble/humble.g:693:7: EOL
                    	    {
                    	    String theStatement = s.toString();

                    	    statements.append(theStatement.substring(0, theStatement.length()));

                    	    match(input,EOL,FOLLOW_EOL_in_module3175); 

                    	    statements.append(".call();");

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    statements.append("}");

                    }


                    }
                    break;

            }


            result.append(" @Override public Callable call(Callable... args) {return this;}");

            statements.append("}");

            result.append(statements);

            match(input,EOF,FOLLOW_EOF_in_module3231); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "module"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\41\uffff";
    static final String DFA14_eofS =
        "\41\uffff";
    static final String DFA14_minS =
        "\1\7\4\4\1\23\2\uffff\1\23\2\uffff\1\45\1\32\1\4\1\7\4\11\1\23\1"+
        "\7\1\4\1\45\4\11\1\23\2\uffff\1\11\1\45\1\11";
    static final String DFA14_maxS =
        "\1\50\4\52\1\23\2\uffff\1\23\2\uffff\1\45\1\32\1\52\1\50\4\46\1"+
        "\23\1\50\1\52\1\45\4\46\1\23\2\uffff\1\46\1\45\1\46";
    static final String DFA14_acceptS =
        "\6\uffff\1\3\1\4\1\uffff\1\1\1\2\21\uffff\1\5\1\6\3\uffff";
    static final String DFA14_specialS =
        "\41\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\3\13\uffff\1\1\3\uffff\1\5\2\uffff\1\6\1\7\3\uffff\1\10\1"+
            "\uffff\1\4\6\uffff\1\2",
            "\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\1\uffff\3\11\4"+
            "\uffff\1\11\3\uffff\1\12\1\uffff\3\11\3\uffff\1\11\1\uffff\1"+
            "\11\1\uffff\2\11\2\uffff\1\11",
            "\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\1\uffff\3\11\4"+
            "\uffff\1\11\3\uffff\1\12\1\uffff\3\11\3\uffff\1\11\1\uffff\1"+
            "\11\1\uffff\2\11\2\uffff\1\11",
            "\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\1\uffff\3\11\4"+
            "\uffff\1\11\3\uffff\1\12\1\uffff\3\11\3\uffff\1\11\1\uffff\1"+
            "\11\1\uffff\2\11\2\uffff\1\11",
            "\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\1\uffff\3\11\4"+
            "\uffff\1\11\3\uffff\1\12\1\uffff\3\11\3\uffff\1\11\1\uffff\1"+
            "\11\1\uffff\2\11\2\uffff\1\11",
            "\1\13",
            "",
            "",
            "\1\14",
            "",
            "",
            "\1\15",
            "\1\16",
            "\1\11\1\uffff\1\11\2\uffff\1\11\3\uffff\1\11\1\uffff\3\11\4"+
            "\uffff\1\11\3\uffff\1\12\1\uffff\3\11\3\uffff\1\11\1\uffff\1"+
            "\11\1\uffff\2\11\2\uffff\1\11",
            "\1\21\13\uffff\1\17\3\uffff\1\23\11\uffff\1\22\6\uffff\1\20",
            "\1\24\34\uffff\1\25",
            "\1\24\34\uffff\1\25",
            "\1\24\34\uffff\1\25",
            "\1\24\34\uffff\1\25",
            "\1\26",
            "\1\31\13\uffff\1\27\3\uffff\1\33\11\uffff\1\32\6\uffff\1\30",
            "\1\35\1\uffff\1\35\2\uffff\1\35\3\uffff\1\35\1\uffff\3\35\4"+
            "\uffff\1\35\3\uffff\1\34\1\uffff\3\35\3\uffff\1\35\1\uffff\1"+
            "\35\1\uffff\2\35\2\uffff\1\35",
            "\1\36",
            "\1\24\34\uffff\1\25",
            "\1\24\34\uffff\1\25",
            "\1\24\34\uffff\1\25",
            "\1\24\34\uffff\1\25",
            "\1\37",
            "",
            "",
            "\1\24\34\uffff\1\25",
            "\1\40",
            "\1\24\34\uffff\1\25"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "231:3: (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list |o= obj t3= tuple |o2= obj )";
        }
    }
 

    public static final BitSet FOLLOW_PACKAGE_in_package_statement438 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_package_statement442 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_DOT_in_package_statement453 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_package_statement457 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_EOL_in_package_statement466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_extends_statement486 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_extends_statement490 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EOL_in_extends_statement492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_import_statment511 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_import_statment515 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_DOT_in_import_statment526 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_import_statment530 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_EOL_in_import_statment539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_dereference573 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DEREF_in_dereference579 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LSB_in_dereference586 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_IDENT_in_dereference604 = new BitSet(new long[]{0x0000008000000200L});
    public static final BitSet FOLLOW_COMMA_in_dereference630 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_dereference646 = new BitSet(new long[]{0x0000008000000200L});
    public static final BitSet FOLLOW_RSB_in_dereference672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_list_slice698 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DEREF_in_list_slice704 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LSB_in_list_slice711 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_list_slice717 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_list_slice724 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_list_slice730 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RSB_in_list_slice736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LAB_in_type755 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_type759 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RAB_in_type761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_obj781 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_obj785 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LPAREN_in_obj796 = new BitSet(new long[]{0x0000010200880080L});
    public static final BitSet FOLLOW_callable_in_obj804 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_COMMA_in_obj817 = new BitSet(new long[]{0x0000010200880080L});
    public static final BitSet FOLLOW_callable_in_obj826 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_RPAREN_in_obj851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_callable875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_callable885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_callable897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_callable919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_callable929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tuple957 = new BitSet(new long[]{0x000001438D9808A0L});
    public static final BitSet FOLLOW_statement_in_tuple977 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_function_in_tuple990 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_COMMA_in_tuple1012 = new BitSet(new long[]{0x000001038D9808A0L});
    public static final BitSet FOLLOW_statement_in_tuple1029 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_function_in_tuple1042 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_RPAREN_in_tuple1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSB_in_list1091 = new BitSet(new long[]{0x000001838C980080L});
    public static final BitSet FOLLOW_compound_expression_in_list1111 = new BitSet(new long[]{0x0000008000000200L});
    public static final BitSet FOLLOW_COMMA_in_list1132 = new BitSet(new long[]{0x000001038C980080L});
    public static final BitSet FOLLOW_compound_expression_in_list1149 = new BitSet(new long[]{0x0000008000000200L});
    public static final BitSet FOLLOW_RSB_in_list1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callable_in_expression1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callable_in_expression1227 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_tuple_in_expression1258 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_tuple_in_expression1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_expression1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obj_in_expression1325 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_tuple_in_expression1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obj_in_expression1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_compound_expression_dot1383 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_compound_expression_dot1394 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_expression_in_compound_expression_dot1398 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_compound_expression_dot_in_compound_expression_mult_div1424 = new BitSet(new long[]{0x0000000060002002L});
    public static final BitSet FOLLOW_MULT_in_compound_expression_mult_div1435 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_dot_in_compound_expression_mult_div1440 = new BitSet(new long[]{0x0000000060002002L});
    public static final BitSet FOLLOW_DIV_in_compound_expression_mult_div1449 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_dot_in_compound_expression_mult_div1454 = new BitSet(new long[]{0x0000000060002002L});
    public static final BitSet FOLLOW_MOD_in_compound_expression_mult_div1463 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_dot_in_compound_expression_mult_div1467 = new BitSet(new long[]{0x0000000060002002L});
    public static final BitSet FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1496 = new BitSet(new long[]{0x0000001010000002L});
    public static final BitSet FOLLOW_PLUS_in_compound_expression_plus_minus1507 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1511 = new BitSet(new long[]{0x0000001010000002L});
    public static final BitSet FOLLOW_MINUS_in_compound_expression_plus_minus1520 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1524 = new BitSet(new long[]{0x0000001010000002L});
    public static final BitSet FOLLOW_compound_expression_plus_minus_in_compound_expression_is1552 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_IS_in_compound_expression_is1563 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_plus_minus_in_compound_expression_is1567 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_compound_expression_is_in_compound_expression_not1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_compound_expression_not1605 = new BitSet(new long[]{0x000001028C880080L});
    public static final BitSet FOLLOW_compound_expression_is_in_compound_expression_not1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_expression_not_in_compound_expression_and1632 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_compound_expression_and1643 = new BitSet(new long[]{0x000001038C880080L});
    public static final BitSet FOLLOW_compound_expression_not_in_compound_expression_and1648 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compound_expression_and_in_compound_expression_or1675 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_OR_in_compound_expression_or1686 = new BitSet(new long[]{0x000001038C880080L});
    public static final BitSet FOLLOW_compound_expression_and_in_compound_expression_or1691 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_compound_expression_or_in_compound_expression1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_compound_expression1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_conditional1756 = new BitSet(new long[]{0x000001038C980080L});
    public static final BitSet FOLLOW_compound_expression_in_conditional1760 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_THEN_in_conditional1762 = new BitSet(new long[]{0x000001038C980080L});
    public static final BitSet FOLLOW_compound_expression_in_conditional1766 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ELSE_in_conditional1768 = new BitSet(new long[]{0x000001038C980080L});
    public static final BitSet FOLLOW_compound_expression_in_conditional1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LAMBDA_in_lambda1917 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LPAREN_in_lambda1925 = new BitSet(new long[]{0x0000004000880000L});
    public static final BitSet FOLLOW_LAB_in_lambda1951 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lambda1955 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RAB_in_lambda1957 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lambda1961 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_IDENT_in_lambda2010 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_dereference_in_lambda2046 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_list_slice_in_lambda2064 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_COMMA_in_lambda2095 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lambda2114 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_dereference_in_lambda2140 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_list_slice_in_lambda2158 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_RPAREN_in_lambda2190 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_AS_in_lambda2206 = new BitSet(new long[]{0x000001038D9800A0L});
    public static final BitSet FOLLOW_compound_expression_in_lambda2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lambda_in_lambda2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_expression_in_statement2283 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_lambda_in_statement2299 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_BINDS_in_statement2322 = new BitSet(new long[]{0x000001038C980080L});
    public static final BitSet FOLLOW_compound_expression_in_statement2326 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_BINDS_in_statement2373 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_lambda_in_statement2377 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_DEF_in_function2431 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_function2435 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LPAREN_in_function2445 = new BitSet(new long[]{0x0000004000880000L});
    public static final BitSet FOLLOW_LAB_in_function2482 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_function2486 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RAB_in_function2488 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_function2492 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_IDENT_in_function2535 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_dereference_in_function2567 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_list_slice_in_function2588 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_COMMA_in_function2615 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_function2626 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_dereference_in_function2648 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_list_slice_in_function2664 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_RPAREN_in_function2696 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_AS_in_function2722 = new BitSet(new long[]{0x000001038D9800A0L});
    public static final BitSet FOLLOW_statement_in_function2737 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EOL_in_function2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_typedef2804 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LAB_in_typedef2806 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_typedef2810 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RAB_in_typedef2812 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LPAREN_in_typedef2833 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_IDENT_in_typedef2850 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_COMMA_in_typedef2873 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_typedef2884 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_RPAREN_in_typedef2918 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_AS_in_typedef2947 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_function_in_typedef2957 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_EOL_in_typedef2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_package_statement_in_module3006 = new BitSet(new long[]{0x000001038DBC08A0L});
    public static final BitSet FOLLOW_import_statment_in_module3034 = new BitSet(new long[]{0x000001038DBC08A0L});
    public static final BitSet FOLLOW_extends_statement_in_module3063 = new BitSet(new long[]{0x000001038D9808A0L});
    public static final BitSet FOLLOW_typedef_in_module3095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_function_in_module3130 = new BitSet(new long[]{0x000001038D9808A0L});
    public static final BitSet FOLLOW_statement_in_module3143 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EOL_in_module3175 = new BitSet(new long[]{0x000001038D9808A0L});
    public static final BitSet FOLLOW_EOF_in_module3231 = new BitSet(new long[]{0x0000000000000002L});

}