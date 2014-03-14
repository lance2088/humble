// $ANTLR 3.4 /home/nickpeck/NetBeansProjects/HumbleV3/humble.g 2014-02-06 18:13:25

package humble.compiler;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class humbleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "AS", "BINDS", "BOOL", "COLON", "COMMA", "COMMENT", "DEF", "DEREF", "DIV", "DO", "ELSE", "EOL", "EXTENDS", "IDENT", "IF", "IMPORT", "IS", "LAB", "LAMBDA", "LINE_COMMENT", "LPAREN", "LSB", "MINUS", "MOD", "MULT", "NOT", "NUMBER", "OR", "PACKAGE", "PLUS", "RAB", "RPAREN", "RSB", "STR", "TAIL", "THEN", "WHITESPACE"
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
    public String getGrammarFileName() { return "/home/nickpeck/NetBeansProjects/HumbleV3/humble.g"; }


      private String moduleName;
      private ArrayList<String> imports = new ArrayList<String>();

      public String getModuleName() {
        return moduleName;
      }
      
      public void setModuleName(String name) {
      	moduleName = name;
      }



    // $ANTLR start "package_statement"
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:87:1: package_statement returns [String result] : PACKAGE i= expression EOL ;
    public final String package_statement() throws RecognitionException {
        String result = null;


        StringBuilder i =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:88:2: ( PACKAGE i= expression EOL )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:88:4: PACKAGE i= expression EOL
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_package_statement425); 

            pushFollow(FOLLOW_expression_in_package_statement429);
            i=expression();

            state._fsp--;


            match(input,EOL,FOLLOW_EOL_in_package_statement431); 

            result ="package " + i.toString() + ";";

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:92:1: extends_statement returns [String result] : EXTENDS i= expression EOL ;
    public final String extends_statement() throws RecognitionException {
        String result = null;


        StringBuilder i =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:93:2: ( EXTENDS i= expression EOL )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:93:4: EXTENDS i= expression EOL
            {
            match(input,EXTENDS,FOLLOW_EXTENDS_in_extends_statement451); 

            pushFollow(FOLLOW_expression_in_extends_statement455);
            i=expression();

            state._fsp--;


            match(input,EOL,FOLLOW_EOL_in_extends_statement457); 

            result ="extends " + i.toString();

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:97:1: import_statment returns [String result] : IMPORT e= expression EOL ;
    public final String import_statment() throws RecognitionException {
        String result = null;


        StringBuilder e =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:98:2: ( IMPORT e= expression EOL )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:98:4: IMPORT e= expression EOL
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_import_statment476); 

            pushFollow(FOLLOW_expression_in_import_statment480);
            e=expression();

            state._fsp--;


            match(input,EOL,FOLLOW_EOL_in_import_statment482); 


            			if(e.toString().endsWith(".*")) {
            				System.err.println("Global package imports are not allowed in Humble.");
            				System.exit(1);
            			}
            		

            result ="import " + e.toString() + ";";

            imports.add(e.toString());

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:109:1: dereference returns [LinkedList<String> result] :i= IDENT DEREF LSB ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )? RSB ;
    public final LinkedList<String> dereference() throws RecognitionException {
        LinkedList<String> result = null;


        Token i=null;
        Token i2=null;
        Token i3=null;

        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:110:2: (i= IDENT DEREF LSB ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )? RSB )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:110:4: i= IDENT DEREF LSB ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )? RSB
            {
            result = new LinkedList<String>();

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_dereference516); 

            result.add(i.getText());

            match(input,DEREF,FOLLOW_DEREF_in_dereference522); 

            match(input,LSB,FOLLOW_LSB_in_dereference529); 

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:114:3: ( (i2= IDENT ) ( COMMA (i3= IDENT ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:115:4: (i2= IDENT ) ( COMMA (i3= IDENT ) )*
                    {
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:115:4: (i2= IDENT )
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:116:6: i2= IDENT
                    {
                    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_dereference547); 

                    result.add(i2.getText());

                    }


                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:120:4: ( COMMA (i3= IDENT ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:121:5: COMMA (i3= IDENT )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_dereference573); 

                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:122:5: (i3= IDENT )
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:123:6: i3= IDENT
                    	    {
                    	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_dereference589); 

                    	    result.add(i3.getText());

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RSB,FOLLOW_RSB_in_dereference615); 

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:134:1: list_slice returns [LinkedList<String> result] :i1= IDENT DEREF LSB i2= IDENT COLON i3= IDENT RSB ;
    public final LinkedList<String> list_slice() throws RecognitionException {
        LinkedList<String> result = null;


        Token i1=null;
        Token i2=null;
        Token i3=null;

        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:135:2: (i1= IDENT DEREF LSB i2= IDENT COLON i3= IDENT RSB )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:135:4: i1= IDENT DEREF LSB i2= IDENT COLON i3= IDENT RSB
            {
            result = new LinkedList<String>();

            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_list_slice641); 

            result.add(i1.getText());

            match(input,DEREF,FOLLOW_DEREF_in_list_slice647); 

            match(input,LSB,FOLLOW_LSB_in_list_slice654); 

            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_list_slice660); 

            result.add(i2.getText());

            match(input,COLON,FOLLOW_COLON_in_list_slice667); 

            i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_list_slice673); 

            result.add(i3.getText());

            match(input,RSB,FOLLOW_RSB_in_list_slice679); 

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:145:1: type returns [String result] : LAB i= IDENT RAB ;
    public final String type() throws RecognitionException {
        String result = null;


        Token i=null;

        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:146:2: ( LAB i= IDENT RAB )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:146:4: LAB i= IDENT RAB
            {
            match(input,LAB,FOLLOW_LAB_in_type695); 

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_type699); 

            match(input,RAB,FOLLOW_RAB_in_type701); 

            result = " new _Type(" + i.getText() + ".class)";

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



    // $ANTLR start "callable"
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:151:1: callable returns [String result] : (id= IDENT |s= STR |b= BOOL |n= NUMBER |t= type );
    public final String callable() throws RecognitionException {
        String result = null;


        Token id=null;
        Token s=null;
        Token b=null;
        Token n=null;
        String t =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:152:2: (id= IDENT |s= STR |b= BOOL |n= NUMBER |t= type )
            int alt3=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt3=1;
                }
                break;
            case STR:
                {
                alt3=2;
                }
                break;
            case BOOL:
                {
                alt3=3;
                }
                break;
            case NUMBER:
                {
                alt3=4;
                }
                break;
            case LAB:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:152:4: id= IDENT
                    {
                    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_callable722); 

                    result = id.getText();

                    }
                    break;
                case 2 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:153:5: s= STR
                    {
                    s=(Token)match(input,STR,FOLLOW_STR_in_callable732); 

                    result = " new _String(" + s.getText() + ")";

                    }
                    break;
                case 3 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:155:5: b= BOOL
                    {
                    b=(Token)match(input,BOOL,FOLLOW_BOOL_in_callable744); 

                    result = " new _Boolean(" + b.getText() + ")";

                    }
                    break;
                case 4 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:160:5: n= NUMBER
                    {
                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_callable766); 

                    result = " new _Number(" + n.getText() + ")";

                    }
                    break;
                case 5 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:161:5: t= type
                    {
                    pushFollow(FOLLOW_type_in_callable776);
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:165:1: tuple returns [StringBuilder result] : LPAREN ( (e1= statement ) ( COMMA (e2= statement ) )* )? RPAREN ;
    public final StringBuilder tuple() throws RecognitionException {
        StringBuilder result = null;


        StringBuilder e1 =null;

        StringBuilder e2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:166:2: ( LPAREN ( (e1= statement ) ( COMMA (e2= statement ) )* )? RPAREN )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:167:3: LPAREN ( (e1= statement ) ( COMMA (e2= statement ) )* )? RPAREN
            {
            result = new StringBuilder();

            match(input,LPAREN,FOLLOW_LPAREN_in_tuple804); 

            result.append('(');

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:169:3: ( (e1= statement ) ( COMMA (e2= statement ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==AS||LA5_0==BOOL||(LA5_0 >= IDENT && LA5_0 <= IF)||(LA5_0 >= LAB && LA5_0 <= LAMBDA)||(LA5_0 >= LPAREN && LA5_0 <= LSB)||(LA5_0 >= NOT && LA5_0 <= NUMBER)||LA5_0==STR) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:170:4: (e1= statement ) ( COMMA (e2= statement ) )*
                    {
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:170:4: (e1= statement )
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:171:6: e1= statement
                    {
                    pushFollow(FOLLOW_statement_in_tuple824);
                    e1=statement();

                    state._fsp--;


                    result.append(e1.toString());

                    }


                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:174:4: ( COMMA (e2= statement ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==COMMA) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:175:5: COMMA (e2= statement )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_tuple845); 

                    	    result.append(", ");

                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:176:5: (e2= statement )
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:177:6: e2= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_tuple862);
                    	    e2=statement();

                    	    state._fsp--;


                    	    result.append(e2.toString());

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_tuple883); 

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:183:1: list returns [StringBuilder result] :l= LSB ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )? RSB ;
    public final StringBuilder list() throws RecognitionException {
        StringBuilder result = null;


        Token l=null;
        String e1 =null;

        String e2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:184:2: (l= LSB ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )? RSB )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:185:3: l= LSB ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )? RSB
            {
            result = new StringBuilder();

            l=(Token)match(input,LSB,FOLLOW_LSB_in_list910); 

            result.append(" new _List(");

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:187:3: ( (e1= compound_expression ) ( COMMA (e2= compound_expression ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==BOOL||(LA7_0 >= IDENT && LA7_0 <= IF)||LA7_0==LAB||(LA7_0 >= LPAREN && LA7_0 <= LSB)||(LA7_0 >= NOT && LA7_0 <= NUMBER)||LA7_0==STR) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:188:4: (e1= compound_expression ) ( COMMA (e2= compound_expression ) )*
                    {
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:188:4: (e1= compound_expression )
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:189:6: e1= compound_expression
                    {
                    pushFollow(FOLLOW_compound_expression_in_list930);
                    e1=compound_expression();

                    state._fsp--;


                    result.append(e1.toString());

                    }


                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:192:4: ( COMMA (e2= compound_expression ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:193:5: COMMA (e2= compound_expression )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_list951); 

                    	    result.append(", ");

                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:194:5: (e2= compound_expression )
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:195:6: e2= compound_expression
                    	    {
                    	    pushFollow(FOLLOW_compound_expression_in_list968);
                    	    e2=compound_expression();

                    	    state._fsp--;


                    	    result.append(e2.toString());

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RSB,FOLLOW_RSB_in_list989); 

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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:202:1: expression returns [StringBuilder result] : (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list ) ;
    public final StringBuilder expression() throws RecognitionException {
        StringBuilder result = null;


        String a1 =null;

        String a2 =null;

        StringBuilder t1 =null;

        StringBuilder t2 =null;

        StringBuilder li =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:203:2: ( (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list ) )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:204:3: (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list )
            {
            result = new StringBuilder();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:205:3: (a1= callable | (a2= callable (t1= tuple )+ ) |t2= tuple |li= list )
            int alt9=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==AND||LA9_1==BINDS||LA9_1==COMMA||LA9_1==DIV||(LA9_1 >= ELSE && LA9_1 <= EOL)||LA9_1==IS||(LA9_1 >= MINUS && LA9_1 <= MULT)||LA9_1==OR||LA9_1==PLUS||(LA9_1 >= RPAREN && LA9_1 <= RSB)||LA9_1==THEN) ) {
                    alt9=1;
                }
                else if ( (LA9_1==LPAREN) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
                }
                break;
            case STR:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==AND||LA9_2==BINDS||LA9_2==COMMA||LA9_2==DIV||(LA9_2 >= ELSE && LA9_2 <= EOL)||LA9_2==IS||(LA9_2 >= MINUS && LA9_2 <= MULT)||LA9_2==OR||LA9_2==PLUS||(LA9_2 >= RPAREN && LA9_2 <= RSB)||LA9_2==THEN) ) {
                    alt9=1;
                }
                else if ( (LA9_2==LPAREN) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;

                }
                }
                break;
            case BOOL:
                {
                int LA9_3 = input.LA(2);

                if ( (LA9_3==AND||LA9_3==BINDS||LA9_3==COMMA||LA9_3==DIV||(LA9_3 >= ELSE && LA9_3 <= EOL)||LA9_3==IS||(LA9_3 >= MINUS && LA9_3 <= MULT)||LA9_3==OR||LA9_3==PLUS||(LA9_3 >= RPAREN && LA9_3 <= RSB)||LA9_3==THEN) ) {
                    alt9=1;
                }
                else if ( (LA9_3==LPAREN) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA9_4 = input.LA(2);

                if ( (LA9_4==AND||LA9_4==BINDS||LA9_4==COMMA||LA9_4==DIV||(LA9_4 >= ELSE && LA9_4 <= EOL)||LA9_4==IS||(LA9_4 >= MINUS && LA9_4 <= MULT)||LA9_4==OR||LA9_4==PLUS||(LA9_4 >= RPAREN && LA9_4 <= RSB)||LA9_4==THEN) ) {
                    alt9=1;
                }
                else if ( (LA9_4==LPAREN) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 4, input);

                    throw nvae;

                }
                }
                break;
            case LAB:
                {
                int LA9_5 = input.LA(2);

                if ( (LA9_5==IDENT) ) {
                    int LA9_10 = input.LA(3);

                    if ( (LA9_10==RAB) ) {
                        int LA9_11 = input.LA(4);

                        if ( (LA9_11==AND||LA9_11==BINDS||LA9_11==COMMA||LA9_11==DIV||(LA9_11 >= ELSE && LA9_11 <= EOL)||LA9_11==IS||(LA9_11 >= MINUS && LA9_11 <= MULT)||LA9_11==OR||LA9_11==PLUS||(LA9_11 >= RPAREN && LA9_11 <= RSB)||LA9_11==THEN) ) {
                            alt9=1;
                        }
                        else if ( (LA9_11==LPAREN) ) {
                            alt9=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 11, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 10, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 5, input);

                    throw nvae;

                }
                }
                break;
            case LPAREN:
                {
                alt9=3;
                }
                break;
            case LSB:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:206:4: a1= callable
                    {
                    pushFollow(FOLLOW_callable_in_expression1026);
                    a1=callable();

                    state._fsp--;


                    result.append(a1);

                    }
                    break;
                case 2 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:207:7: (a2= callable (t1= tuple )+ )
                    {
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:207:7: (a2= callable (t1= tuple )+ )
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:209:6: a2= callable (t1= tuple )+
                    {
                    pushFollow(FOLLOW_callable_in_expression1046);
                    a2=callable();

                    state._fsp--;


                    StringBuilder tuples1 = new StringBuilder();

                    StringBuilder tuples2 = new StringBuilder();

                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:212:6: (t1= tuple )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==LPAREN) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:213:7: t1= tuple
                    	    {
                    	    pushFollow(FOLLOW_tuple_in_expression1077);
                    	    t1=tuple();

                    	    state._fsp--;


                    	    tuples1.append(".call" + t1.toString());

                    	    tuples2.append(t1.toString());

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
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:239:6: t2= tuple
                    {
                    pushFollow(FOLLOW_tuple_in_expression1120);
                    t2=tuple();

                    state._fsp--;


                    result.append(t2.toString());

                    }
                    break;
                case 4 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:240:6: li= list
                    {
                    pushFollow(FOLLOW_list_in_expression1131);
                    li=list();

                    state._fsp--;


                    result.append(li.toString());

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



    // $ANTLR start "compound_expression_mult_div"
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:247:1: compound_expression_mult_div returns [String result] : e= expression ( MULT e2= expression | DIV e3= expression | MOD e4= expression )* ;
    public final String compound_expression_mult_div() throws RecognitionException {
        String result = null;


        StringBuilder e =null;

        StringBuilder e2 =null;

        StringBuilder e3 =null;

        StringBuilder e4 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:248:2: (e= expression ( MULT e2= expression | DIV e3= expression | MOD e4= expression )* )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:249:3: e= expression ( MULT e2= expression | DIV e3= expression | MOD e4= expression )*
            {
            pushFollow(FOLLOW_expression_in_compound_expression_mult_div1163);
            e=expression();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:250:3: ( MULT e2= expression | DIV e3= expression | MOD e4= expression )*
            loop10:
            do {
                int alt10=4;
                switch ( input.LA(1) ) {
                case MULT:
                    {
                    alt10=1;
                    }
                    break;
                case DIV:
                    {
                    alt10=2;
                    }
                    break;
                case MOD:
                    {
                    alt10=3;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:251:4: MULT e2= expression
            	    {
            	    match(input,MULT,FOLLOW_MULT_in_compound_expression_mult_div1174); 

            	    pushFollow(FOLLOW_expression_in_compound_expression_mult_div1179);
            	    e2=expression();

            	    state._fsp--;


            	    result = "multiply.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;
            	case 2 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:252:6: DIV e3= expression
            	    {
            	    match(input,DIV,FOLLOW_DIV_in_compound_expression_mult_div1188); 

            	    pushFollow(FOLLOW_expression_in_compound_expression_mult_div1193);
            	    e3=expression();

            	    state._fsp--;


            	    result = "divide.call(" + result + ", " + e3.toString() + ")";

            	    }
            	    break;
            	case 3 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:253:6: MOD e4= expression
            	    {
            	    match(input,MOD,FOLLOW_MOD_in_compound_expression_mult_div1202); 

            	    pushFollow(FOLLOW_expression_in_compound_expression_mult_div1206);
            	    e4=expression();

            	    state._fsp--;


            	    result = "modulus.call(" + result + ", " + e4.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:258:1: compound_expression_plus_minus returns [String result] : e= compound_expression_mult_div ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )* ;
    public final String compound_expression_plus_minus() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;

        String e3 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:259:2: (e= compound_expression_mult_div ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )* )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:260:3: e= compound_expression_mult_div ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )*
            {
            pushFollow(FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1235);
            e=compound_expression_mult_div();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:261:3: ( PLUS e2= compound_expression_mult_div | MINUS e3= compound_expression_mult_div )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==PLUS) ) {
                    alt11=1;
                }
                else if ( (LA11_0==MINUS) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:262:4: PLUS e2= compound_expression_mult_div
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_compound_expression_plus_minus1246); 

            	    pushFollow(FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1250);
            	    e2=compound_expression_mult_div();

            	    state._fsp--;


            	    result = "plus.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;
            	case 2 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:263:6: MINUS e3= compound_expression_mult_div
            	    {
            	    match(input,MINUS,FOLLOW_MINUS_in_compound_expression_plus_minus1259); 

            	    pushFollow(FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1263);
            	    e3=compound_expression_mult_div();

            	    state._fsp--;


            	    result = "minus.call(" + result + ", " + e3.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:267:1: compound_expression_is returns [String result] : e= compound_expression_plus_minus ( IS e2= compound_expression_plus_minus )* ;
    public final String compound_expression_is() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:268:2: (e= compound_expression_plus_minus ( IS e2= compound_expression_plus_minus )* )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:269:3: e= compound_expression_plus_minus ( IS e2= compound_expression_plus_minus )*
            {
            pushFollow(FOLLOW_compound_expression_plus_minus_in_compound_expression_is1291);
            e=compound_expression_plus_minus();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:270:3: ( IS e2= compound_expression_plus_minus )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==IS) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:271:4: IS e2= compound_expression_plus_minus
            	    {
            	    match(input,IS,FOLLOW_IS_in_compound_expression_is1302); 

            	    pushFollow(FOLLOW_compound_expression_plus_minus_in_compound_expression_is1306);
            	    e2=compound_expression_plus_minus();

            	    state._fsp--;


            	    result = "equals.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:275:1: compound_expression_not returns [String result] : (e= compound_expression_is | NOT e2= compound_expression_is );
    public final String compound_expression_not() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:276:2: (e= compound_expression_is | NOT e2= compound_expression_is )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==BOOL||LA13_0==IDENT||LA13_0==LAB||(LA13_0 >= LPAREN && LA13_0 <= LSB)||LA13_0==NUMBER||LA13_0==STR) ) {
                alt13=1;
            }
            else if ( (LA13_0==NOT) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:277:3: e= compound_expression_is
                    {
                    pushFollow(FOLLOW_compound_expression_is_in_compound_expression_not1334);
                    e=compound_expression_is();

                    state._fsp--;


                    result = e.toString();

                    }
                    break;
                case 2 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:279:4: NOT e2= compound_expression_is
                    {
                    match(input,NOT,FOLLOW_NOT_in_compound_expression_not1344); 

                    pushFollow(FOLLOW_compound_expression_is_in_compound_expression_not1349);
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:282:1: compound_expression_and returns [String result] : e= compound_expression_not ( AND e2= compound_expression_not )* ;
    public final String compound_expression_and() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:283:2: (e= compound_expression_not ( AND e2= compound_expression_not )* )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:284:3: e= compound_expression_not ( AND e2= compound_expression_not )*
            {
            pushFollow(FOLLOW_compound_expression_not_in_compound_expression_and1371);
            e=compound_expression_not();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:285:3: ( AND e2= compound_expression_not )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==AND) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:286:4: AND e2= compound_expression_not
            	    {
            	    match(input,AND,FOLLOW_AND_in_compound_expression_and1382); 

            	    pushFollow(FOLLOW_compound_expression_not_in_compound_expression_and1387);
            	    e2=compound_expression_not();

            	    state._fsp--;


            	    result = "and.call(" + result + ", " + e2.toString() + ")";

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:290:1: compound_expression_or returns [String result] : e= compound_expression_and ( OR e2= compound_expression_and )* ;
    public final String compound_expression_or() throws RecognitionException {
        String result = null;


        String e =null;

        String e2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:291:2: (e= compound_expression_and ( OR e2= compound_expression_and )* )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:292:3: e= compound_expression_and ( OR e2= compound_expression_and )*
            {
            pushFollow(FOLLOW_compound_expression_and_in_compound_expression_or1414);
            e=compound_expression_and();

            state._fsp--;


            result = e.toString();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:293:3: ( OR e2= compound_expression_and )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==OR) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:294:4: OR e2= compound_expression_and
            	    {
            	    match(input,OR,FOLLOW_OR_in_compound_expression_or1425); 

            	    pushFollow(FOLLOW_compound_expression_and_in_compound_expression_or1430);
            	    e2=compound_expression_and();

            	    state._fsp--;


            	    result = "or.call(" + result + ", " + e2.toString() + ")";

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
    // $ANTLR end "compound_expression_or"



    // $ANTLR start "compound_expression"
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:307:1: compound_expression returns [String result] : (e= compound_expression_or |c= conditional );
    public final String compound_expression() throws RecognitionException {
        String result = null;


        String e =null;

        StringBuilder c =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:308:2: (e= compound_expression_or |c= conditional )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==BOOL||LA16_0==IDENT||LA16_0==LAB||(LA16_0 >= LPAREN && LA16_0 <= LSB)||(LA16_0 >= NOT && LA16_0 <= NUMBER)||LA16_0==STR) ) {
                alt16=1;
            }
            else if ( (LA16_0==IF) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:309:2: e= compound_expression_or
                    {
                    pushFollow(FOLLOW_compound_expression_or_in_compound_expression1462);
                    e=compound_expression_or();

                    state._fsp--;


                    result = e.toString();

                    }
                    break;
                case 2 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:310:4: c= conditional
                    {
                    pushFollow(FOLLOW_conditional_in_compound_expression1471);
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:314:1: conditional returns [StringBuilder result] : i= IF e2= compound_expression THEN e3= compound_expression ELSE e4= compound_expression ;
    public final StringBuilder conditional() throws RecognitionException {
        StringBuilder result = null;


        Token i=null;
        String e2 =null;

        String e3 =null;

        String e4 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:315:2: (i= IF e2= compound_expression THEN e3= compound_expression ELSE e4= compound_expression )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:316:4: i= IF e2= compound_expression THEN e3= compound_expression ELSE e4= compound_expression
            {
            i=(Token)match(input,IF,FOLLOW_IF_in_conditional1495); 

            pushFollow(FOLLOW_compound_expression_in_conditional1499);
            e2=compound_expression();

            state._fsp--;


            match(input,THEN,FOLLOW_THEN_in_conditional1501); 

            pushFollow(FOLLOW_compound_expression_in_conditional1505);
            e3=compound_expression();

            state._fsp--;


            match(input,ELSE,FOLLOW_ELSE_in_conditional1507); 

            pushFollow(FOLLOW_compound_expression_in_conditional1511);
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:340:1: lambda returns [StringBuilder result] : ( LAMBDA LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )? a= AS (e= compound_expression |l= lambda ) ;
    public final StringBuilder lambda() throws RecognitionException {
        StringBuilder result = null;


        Token i1=null;
        Token i2=null;
        Token a=null;
        LinkedList<String> d1 =null;

        LinkedList<String> ls1 =null;

        LinkedList<String> d2 =null;

        LinkedList<String> ls2 =null;

        String e =null;

        StringBuilder l =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:341:2: ( ( LAMBDA LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )? a= AS (e= compound_expression |l= lambda ) )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:342:3: ( LAMBDA LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )? a= AS (e= compound_expression |l= lambda )
            {
            result = new StringBuilder();

            StringBuilder args = new StringBuilder();

            int argIndex=0;

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:345:3: ( LAMBDA LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LAMBDA) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:346:4: LAMBDA LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN
                    {
                    match(input,LAMBDA,FOLLOW_LAMBDA_in_lambda1653); 

                    match(input,LPAREN,FOLLOW_LPAREN_in_lambda1661); 

                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:349:4: ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==IDENT) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:350:5: (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                            {
                            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:350:5: (i1= IDENT |d1= dereference |ls1= list_slice )
                            int alt17=3;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==IDENT) ) {
                                int LA17_1 = input.LA(2);

                                if ( (LA17_1==COMMA||LA17_1==RPAREN) ) {
                                    alt17=1;
                                }
                                else if ( (LA17_1==DEREF) ) {
                                    int LA17_3 = input.LA(3);

                                    if ( (LA17_3==LSB) ) {
                                        int LA17_4 = input.LA(4);

                                        if ( (LA17_4==IDENT) ) {
                                            int LA17_5 = input.LA(5);

                                            if ( (LA17_5==COLON) ) {
                                                alt17=3;
                                            }
                                            else if ( (LA17_5==COMMA||LA17_5==RSB) ) {
                                                alt17=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 17, 5, input);

                                                throw nvae;

                                            }
                                        }
                                        else if ( (LA17_4==RSB) ) {
                                            alt17=2;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 17, 4, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 17, 3, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 1, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;

                            }
                            switch (alt17) {
                                case 1 :
                                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:351:6: i1= IDENT
                                    {
                                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_lambda1681); 

                                    args.append(" final Callable ");

                                    args.append(i1.getText());

                                    args.append(" = args[" + argIndex + "];");

                                    }
                                    break;
                                case 2 :
                                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:354:8: d1= dereference
                                    {
                                    pushFollow(FOLLOW_dereference_in_lambda1708);
                                    d1=dereference();

                                    state._fsp--;



                                    						args.append(" final Callable " + d1.get(0) + " = ((_List)args[0]);");
                                    						for(int index=1;index<d1.size();index++) {
                                    							args.append(" final Callable " + d1.get(index) + " = ((_List)args[" + argIndex + "]).get(" + (index-1) + ");");
                                    						}
                                    					

                                    }
                                    break;
                                case 3 :
                                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:361:8: ls1= list_slice
                                    {
                                    pushFollow(FOLLOW_list_slice_in_lambda1726);
                                    ls1=list_slice();

                                    state._fsp--;



                                    						args.append(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
                                    						args.append(" final Callable " + ls1.get(1) + " = list_head.call(((_List)args[0]));");
                                    						args.append(" final Callable " + ls1.get(2) + " = list_tail.call(((_List)args[0]));");
                                    					

                                    }
                                    break;

                            }


                            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:369:5: ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==COMMA) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:370:6: COMMA (i2= IDENT |d2= dereference |ls2= list_slice )
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_lambda1757); 

                            	    argIndex ++;

                            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:371:6: (i2= IDENT |d2= dereference |ls2= list_slice )
                            	    int alt18=3;
                            	    int LA18_0 = input.LA(1);

                            	    if ( (LA18_0==IDENT) ) {
                            	        int LA18_1 = input.LA(2);

                            	        if ( (LA18_1==COMMA||LA18_1==RPAREN) ) {
                            	            alt18=1;
                            	        }
                            	        else if ( (LA18_1==DEREF) ) {
                            	            int LA18_3 = input.LA(3);

                            	            if ( (LA18_3==LSB) ) {
                            	                int LA18_4 = input.LA(4);

                            	                if ( (LA18_4==IDENT) ) {
                            	                    int LA18_5 = input.LA(5);

                            	                    if ( (LA18_5==COLON) ) {
                            	                        alt18=3;
                            	                    }
                            	                    else if ( (LA18_5==COMMA||LA18_5==RSB) ) {
                            	                        alt18=2;
                            	                    }
                            	                    else {
                            	                        NoViableAltException nvae =
                            	                            new NoViableAltException("", 18, 5, input);

                            	                        throw nvae;

                            	                    }
                            	                }
                            	                else if ( (LA18_4==RSB) ) {
                            	                    alt18=2;
                            	                }
                            	                else {
                            	                    NoViableAltException nvae =
                            	                        new NoViableAltException("", 18, 4, input);

                            	                    throw nvae;

                            	                }
                            	            }
                            	            else {
                            	                NoViableAltException nvae =
                            	                    new NoViableAltException("", 18, 3, input);

                            	                throw nvae;

                            	            }
                            	        }
                            	        else {
                            	            NoViableAltException nvae =
                            	                new NoViableAltException("", 18, 1, input);

                            	            throw nvae;

                            	        }
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 18, 0, input);

                            	        throw nvae;

                            	    }
                            	    switch (alt18) {
                            	        case 1 :
                            	            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:371:7: i2= IDENT
                            	            {
                            	            args.append(",");

                            	            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_lambda1776); 

                            	            args.append(" final Callable ");

                            	            args.append(i2.getText());

                            	            args.append(" = args[" + argIndex + "];");

                            	            }
                            	            break;
                            	        case 2 :
                            	            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:375:7: d2= dereference
                            	            {
                            	            pushFollow(FOLLOW_dereference_in_lambda1802);
                            	            d2=dereference();

                            	            state._fsp--;



                            	            						args.append(" final Callable " + d2.get(0) + " = ((_List)args[" + argIndex + "]);");
                            	            						for(int index2=1;index2<d2.size();index2++) {
                            	            							args.append(" final Callable " + d2.get(index2) + " = ((_List)args[" + argIndex + "]).get(" + (index2-1) + ");");
                            	            						}
                            	            					

                            	            }
                            	            break;
                            	        case 3 :
                            	            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:382:8: ls2= list_slice
                            	            {
                            	            pushFollow(FOLLOW_list_slice_in_lambda1820);
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
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_lambda1852); 

                    }
                    break;

            }


            a=(Token)match(input,AS,FOLLOW_AS_in_lambda1868); 

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:396:3: (e= compound_expression |l= lambda )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==BOOL||(LA22_0 >= IDENT && LA22_0 <= IF)||LA22_0==LAB||(LA22_0 >= LPAREN && LA22_0 <= LSB)||(LA22_0 >= NOT && LA22_0 <= NUMBER)||LA22_0==STR) ) {
                alt22=1;
            }
            else if ( (LA22_0==AS||LA22_0==LAMBDA) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:397:4: e= compound_expression
                    {
                    pushFollow(FOLLOW_compound_expression_in_lambda1880);
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
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:408:6: l= lambda
                    {
                    pushFollow(FOLLOW_lambda_in_lambda1898);
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:424:1: statement returns [StringBuilder result] : ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* ) ;
    public final StringBuilder statement() throws RecognitionException {
        StringBuilder result = null;


        String e1 =null;

        StringBuilder l1 =null;

        String e2 =null;

        StringBuilder l2 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:425:2: ( ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* ) )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:425:4: ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* )
            {
            result = new StringBuilder();

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:426:3: ( (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )* )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:427:4: (e1= compound_expression |l1= lambda ) ( BINDS e2= compound_expression | BINDS l2= lambda )*
            {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:427:4: (e1= compound_expression |l1= lambda )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==BOOL||(LA23_0 >= IDENT && LA23_0 <= IF)||LA23_0==LAB||(LA23_0 >= LPAREN && LA23_0 <= LSB)||(LA23_0 >= NOT && LA23_0 <= NUMBER)||LA23_0==STR) ) {
                alt23=1;
            }
            else if ( (LA23_0==AS||LA23_0==LAMBDA) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:428:5: e1= compound_expression
                    {
                    pushFollow(FOLLOW_compound_expression_in_statement1945);
                    e1=compound_expression();

                    state._fsp--;


                    result.append(e1.toString());

                    }
                    break;
                case 2 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:430:7: l1= lambda
                    {
                    pushFollow(FOLLOW_lambda_in_statement1961);
                    l1=lambda();

                    state._fsp--;


                    result.append(l1.toString());

                    }
                    break;

            }


            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:433:4: ( BINDS e2= compound_expression | BINDS l2= lambda )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==BINDS) ) {
                    int LA24_2 = input.LA(2);

                    if ( (LA24_2==BOOL||(LA24_2 >= IDENT && LA24_2 <= IF)||LA24_2==LAB||(LA24_2 >= LPAREN && LA24_2 <= LSB)||(LA24_2 >= NOT && LA24_2 <= NUMBER)||LA24_2==STR) ) {
                        alt24=1;
                    }
                    else if ( (LA24_2==AS||LA24_2==LAMBDA) ) {
                        alt24=2;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:434:5: BINDS e2= compound_expression
            	    {
            	    match(input,BINDS,FOLLOW_BINDS_in_statement1984); 

            	    pushFollow(FOLLOW_compound_expression_in_statement1988);
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
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:441:7: BINDS l2= lambda
            	    {
            	    match(input,BINDS,FOLLOW_BINDS_in_statement2035); 

            	    pushFollow(FOLLOW_lambda_in_statement2039);
            	    l2=lambda();

            	    state._fsp--;


            	    result.append( ".bindTo(" + l2.toString() + ")");

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:449:1: function returns [StringBuilder result] : DEF i= IDENT LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN AS (s1= statement ) EOL ;
    public final StringBuilder function() throws RecognitionException {
        StringBuilder result = null;


        Token i=null;
        Token i1=null;
        Token i2=null;
        LinkedList<String> d1 =null;

        LinkedList<String> ls1 =null;

        LinkedList<String> d2 =null;

        LinkedList<String> ls2 =null;

        StringBuilder s1 =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:450:2: ( DEF i= IDENT LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN AS (s1= statement ) EOL )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:451:3: DEF i= IDENT LPAREN ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )? RPAREN AS (s1= statement ) EOL
            {
            result = new StringBuilder();

            LinkedList<String> args = new LinkedList<String>();

            match(input,DEF,FOLLOW_DEF_in_function2093); 

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2097); 

            int argIndex=0;

            match(input,LPAREN,FOLLOW_LPAREN_in_function2107); 

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:457:3: ( (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDENT) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:458:4: (i1= IDENT |d1= dereference |ls1= list_slice ) ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                    {
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:458:4: (i1= IDENT |d1= dereference |ls1= list_slice )
                    int alt25=3;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==IDENT) ) {
                        int LA25_1 = input.LA(2);

                        if ( (LA25_1==COMMA||LA25_1==RPAREN) ) {
                            alt25=1;
                        }
                        else if ( (LA25_1==DEREF) ) {
                            int LA25_3 = input.LA(3);

                            if ( (LA25_3==LSB) ) {
                                int LA25_4 = input.LA(4);

                                if ( (LA25_4==IDENT) ) {
                                    int LA25_5 = input.LA(5);

                                    if ( (LA25_5==COLON) ) {
                                        alt25=3;
                                    }
                                    else if ( (LA25_5==COMMA||LA25_5==RSB) ) {
                                        alt25=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 25, 5, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA25_4==RSB) ) {
                                    alt25=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 25, 4, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 25, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;

                    }
                    switch (alt25) {
                        case 1 :
                            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:459:5: i1= IDENT
                            {
                            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2124); 

                            args.add(" final Callable " + i1.getText() + " = args[" + argIndex + "];");

                            }
                            break;
                        case 2 :
                            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:462:7: d1= dereference
                            {
                            pushFollow(FOLLOW_dereference_in_function2146);
                            d1=dereference();

                            state._fsp--;



                            					args.add(" final Callable " + d1.get(0) + " = ((_List)args[0]);");
                            					for(int index=1;index<d1.size();index++) {
                            						args.add(" final Callable " + d1.get(index) + " = ((_List)args[0]).get(" + (index-1) + ");");
                            					}
                            				

                            }
                            break;
                        case 3 :
                            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:469:7: ls1= list_slice
                            {
                            pushFollow(FOLLOW_list_slice_in_function2167);
                            ls1=list_slice();

                            state._fsp--;



                            					args.add(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
                            					args.add(" final Callable " + ls1.get(1) + " = list_head.call(((_List)args[0]));");
                            					args.add(" final Callable " + ls1.get(2) + " = list_tail.call(((_List)args[0]));");
                            				

                            }
                            break;

                    }


                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:477:4: ( COMMA (i2= IDENT |d2= dereference |ls2= list_slice ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==COMMA) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:478:5: COMMA (i2= IDENT |d2= dereference |ls2= list_slice )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_function2194); 

                    	    argIndex ++;

                    	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:479:5: (i2= IDENT |d2= dereference |ls2= list_slice )
                    	    int alt26=3;
                    	    int LA26_0 = input.LA(1);

                    	    if ( (LA26_0==IDENT) ) {
                    	        int LA26_1 = input.LA(2);

                    	        if ( (LA26_1==COMMA||LA26_1==RPAREN) ) {
                    	            alt26=1;
                    	        }
                    	        else if ( (LA26_1==DEREF) ) {
                    	            int LA26_3 = input.LA(3);

                    	            if ( (LA26_3==LSB) ) {
                    	                int LA26_4 = input.LA(4);

                    	                if ( (LA26_4==IDENT) ) {
                    	                    int LA26_5 = input.LA(5);

                    	                    if ( (LA26_5==COLON) ) {
                    	                        alt26=3;
                    	                    }
                    	                    else if ( (LA26_5==COMMA||LA26_5==RSB) ) {
                    	                        alt26=2;
                    	                    }
                    	                    else {
                    	                        NoViableAltException nvae =
                    	                            new NoViableAltException("", 26, 5, input);

                    	                        throw nvae;

                    	                    }
                    	                }
                    	                else if ( (LA26_4==RSB) ) {
                    	                    alt26=2;
                    	                }
                    	                else {
                    	                    NoViableAltException nvae =
                    	                        new NoViableAltException("", 26, 4, input);

                    	                    throw nvae;

                    	                }
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 26, 3, input);

                    	                throw nvae;

                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 26, 1, input);

                    	            throw nvae;

                    	        }
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 26, 0, input);

                    	        throw nvae;

                    	    }
                    	    switch (alt26) {
                    	        case 1 :
                    	            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:479:6: i2= IDENT
                    	            {
                    	            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_function2205); 

                    	            args.add(" final Callable " + i2.getText() + " = args[" + argIndex + "];");

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:482:7: d2= dereference
                    	            {
                    	            pushFollow(FOLLOW_dereference_in_function2227);
                    	            d2=dereference();

                    	            state._fsp--;



                    	            					args.add(" final Callable " + d2.get(0) + " = ((_List)args[" + argIndex + "]);");
                    	            					for(int index2=1;index2<d2.size();index2++) {
                    	            						args.add(" final Callable " + d2.get(index2) + " = ((_List)args[" + argIndex + "]).get(" + (index2-1) + ");");
                    	            					}
                    	            				

                    	            }
                    	            break;
                    	        case 3 :
                    	            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:489:7: ls2= list_slice
                    	            {
                    	            pushFollow(FOLLOW_list_slice_in_function2243);
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
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_function2275); 

            result.append("public final static Lambda " + i.getText() + " = new Lambda() {");

            result.append("		@Override");

            result.append("		protected final Callable evaluate(Callable... args) {");

            match(input,AS,FOLLOW_AS_in_function2301); 

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:507:3: (s1= statement )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:509:4: s1= statement
            {
            pushFollow(FOLLOW_statement_in_function2316);
            s1=statement();

            state._fsp--;



            	
            				for(int i3=0;i3<args.size();i3++) {
            					result.append(args.get(i3));
            				}
            				result.append("			return " + s1.toString() + ";");
            			

            }


            result.append("		}");

            result.append("	}");

            match(input,EOL,FOLLOW_EOL_in_function2357); 

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



    // $ANTLR start "module"
    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:542:1: module returns [StringBuilder result] :p= package_statement (i= import_statment )* (es= extends_statement )? (f= function |s= statement ( EOL ) )* EOF ;
    public final StringBuilder module() throws RecognitionException {
        StringBuilder result = null;


        String p =null;

        String i =null;

        String es =null;

        StringBuilder f =null;

        StringBuilder s =null;


        try {
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:543:2: (p= package_statement (i= import_statment )* (es= extends_statement )? (f= function |s= statement ( EOL ) )* EOF )
            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:544:3: p= package_statement (i= import_statment )* (es= extends_statement )? (f= function |s= statement ( EOL ) )* EOF
            {
            result = new StringBuilder();

            pushFollow(FOLLOW_package_statement_in_module2390);
            p=package_statement();

            state._fsp--;


            result.append(p.toString());

            result.append("import humble.runtime.*;");

            result.append("import humble.primitives.*;");

            result.append("import humble.runtime.HumbleRuntimeException;");

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:551:3: (i= import_statment )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==IMPORT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:552:4: i= import_statment
            	    {
            	    pushFollow(FOLLOW_import_statment_in_module2418);
            	    i=import_statment();

            	    state._fsp--;


            	    result.append(i.toString());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            String _extends=" extends Module ";

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:557:3: (es= extends_statement )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==EXTENDS) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:558:4: es= extends_statement
                    {
                    pushFollow(FOLLOW_extends_statement_in_module2447);
                    es=extends_statement();

                    state._fsp--;


                    _extends = es.toString();

                    }
                    break;

            }


            result.append("public class " + getModuleName() + " " + _extends + " {");

            StringBuilder statements = new StringBuilder();

            statements.append("public static void main(String[] args) throws HumbleRuntimeException{");

            // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:565:3: (f= function |s= statement ( EOL ) )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==DEF) ) {
                    alt31=1;
                }
                else if ( (LA31_0==AS||LA31_0==BOOL||(LA31_0 >= IDENT && LA31_0 <= IF)||(LA31_0 >= LAB && LA31_0 <= LAMBDA)||(LA31_0 >= LPAREN && LA31_0 <= LSB)||(LA31_0 >= NOT && LA31_0 <= NUMBER)||LA31_0==STR) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:566:4: f= function
            	    {
            	    pushFollow(FOLLOW_function_in_module2483);
            	    f=function();

            	    state._fsp--;


            	    result.append(f.toString());

            	    }
            	    break;
            	case 2 :
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:567:6: s= statement ( EOL )
            	    {
            	    pushFollow(FOLLOW_statement_in_module2494);
            	    s=statement();

            	    state._fsp--;


            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:568:4: ( EOL )
            	    // /home/nickpeck/NetBeansProjects/HumbleV3/humble.g:569:5: EOL
            	    {
            	    String theStatement = s.toString();

            	    statements.append(theStatement.substring(0, theStatement.length()));

            	    match(input,EOL,FOLLOW_EOL_in_module2518); 

            	    statements.append(".call();");

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            statements.append("}");

            result.append(" @Override public Callable call(Callable... args) {return this;}");

            statements.append("}");

            result.append(statements);

            match(input,EOF,FOLLOW_EOF_in_module2556); 

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


 

    public static final BitSet FOLLOW_PACKAGE_in_package_statement425 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_expression_in_package_statement429 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_EOL_in_package_statement431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_extends_statement451 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_expression_in_extends_statement455 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_EOL_in_extends_statement457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_import_statment476 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_expression_in_import_statment480 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_EOL_in_import_statment482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_dereference516 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DEREF_in_dereference522 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LSB_in_dereference529 = new BitSet(new long[]{0x0000002000040000L});
    public static final BitSet FOLLOW_IDENT_in_dereference547 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_COMMA_in_dereference573 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_dereference589 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_RSB_in_dereference615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_list_slice641 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DEREF_in_list_slice647 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LSB_in_list_slice654 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_list_slice660 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_list_slice667 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_list_slice673 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RSB_in_list_slice679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LAB_in_type695 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_type699 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RAB_in_type701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_callable722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_callable732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_callable744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_callable766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_callable776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tuple804 = new BitSet(new long[]{0x00000050C6CC00A0L});
    public static final BitSet FOLLOW_statement_in_tuple824 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_COMMA_in_tuple845 = new BitSet(new long[]{0x00000040C6CC00A0L});
    public static final BitSet FOLLOW_statement_in_tuple862 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_RPAREN_in_tuple883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSB_in_list910 = new BitSet(new long[]{0x00000060C64C0080L});
    public static final BitSet FOLLOW_compound_expression_in_list930 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_COMMA_in_list951 = new BitSet(new long[]{0x00000040C64C0080L});
    public static final BitSet FOLLOW_compound_expression_in_list968 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_RSB_in_list989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callable_in_expression1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callable_in_expression1046 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_tuple_in_expression1077 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_tuple_in_expression1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_expression1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_compound_expression_mult_div1163 = new BitSet(new long[]{0x0000000030002002L});
    public static final BitSet FOLLOW_MULT_in_compound_expression_mult_div1174 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_expression_in_compound_expression_mult_div1179 = new BitSet(new long[]{0x0000000030002002L});
    public static final BitSet FOLLOW_DIV_in_compound_expression_mult_div1188 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_expression_in_compound_expression_mult_div1193 = new BitSet(new long[]{0x0000000030002002L});
    public static final BitSet FOLLOW_MOD_in_compound_expression_mult_div1202 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_expression_in_compound_expression_mult_div1206 = new BitSet(new long[]{0x0000000030002002L});
    public static final BitSet FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1235 = new BitSet(new long[]{0x0000000408000002L});
    public static final BitSet FOLLOW_PLUS_in_compound_expression_plus_minus1246 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1250 = new BitSet(new long[]{0x0000000408000002L});
    public static final BitSet FOLLOW_MINUS_in_compound_expression_plus_minus1259 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_compound_expression_mult_div_in_compound_expression_plus_minus1263 = new BitSet(new long[]{0x0000000408000002L});
    public static final BitSet FOLLOW_compound_expression_plus_minus_in_compound_expression_is1291 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_IS_in_compound_expression_is1302 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_compound_expression_plus_minus_in_compound_expression_is1306 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_compound_expression_is_in_compound_expression_not1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_compound_expression_not1344 = new BitSet(new long[]{0x0000004086440080L});
    public static final BitSet FOLLOW_compound_expression_is_in_compound_expression_not1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_expression_not_in_compound_expression_and1371 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_compound_expression_and1382 = new BitSet(new long[]{0x00000040C6440080L});
    public static final BitSet FOLLOW_compound_expression_not_in_compound_expression_and1387 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compound_expression_and_in_compound_expression_or1414 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_OR_in_compound_expression_or1425 = new BitSet(new long[]{0x00000040C6440080L});
    public static final BitSet FOLLOW_compound_expression_and_in_compound_expression_or1430 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_compound_expression_or_in_compound_expression1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_compound_expression1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_conditional1495 = new BitSet(new long[]{0x00000040C64C0080L});
    public static final BitSet FOLLOW_compound_expression_in_conditional1499 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_THEN_in_conditional1501 = new BitSet(new long[]{0x00000040C64C0080L});
    public static final BitSet FOLLOW_compound_expression_in_conditional1505 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ELSE_in_conditional1507 = new BitSet(new long[]{0x00000040C64C0080L});
    public static final BitSet FOLLOW_compound_expression_in_conditional1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LAMBDA_in_lambda1653 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lambda1661 = new BitSet(new long[]{0x0000001000040000L});
    public static final BitSet FOLLOW_IDENT_in_lambda1681 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_dereference_in_lambda1708 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_list_slice_in_lambda1726 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_COMMA_in_lambda1757 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_lambda1776 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_dereference_in_lambda1802 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_list_slice_in_lambda1820 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_RPAREN_in_lambda1852 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_AS_in_lambda1868 = new BitSet(new long[]{0x00000040C6CC00A0L});
    public static final BitSet FOLLOW_compound_expression_in_lambda1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lambda_in_lambda1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_expression_in_statement1945 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_lambda_in_statement1961 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_BINDS_in_statement1984 = new BitSet(new long[]{0x00000040C64C0080L});
    public static final BitSet FOLLOW_compound_expression_in_statement1988 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_BINDS_in_statement2035 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_lambda_in_statement2039 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_DEF_in_function2093 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_function2097 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_function2107 = new BitSet(new long[]{0x0000001000040000L});
    public static final BitSet FOLLOW_IDENT_in_function2124 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_dereference_in_function2146 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_list_slice_in_function2167 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_COMMA_in_function2194 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENT_in_function2205 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_dereference_in_function2227 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_list_slice_in_function2243 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_RPAREN_in_function2275 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_AS_in_function2301 = new BitSet(new long[]{0x00000040C6CC00A0L});
    public static final BitSet FOLLOW_statement_in_function2316 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_EOL_in_function2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_package_statement_in_module2390 = new BitSet(new long[]{0x00000040C6DE08A0L});
    public static final BitSet FOLLOW_import_statment_in_module2418 = new BitSet(new long[]{0x00000040C6DE08A0L});
    public static final BitSet FOLLOW_extends_statement_in_module2447 = new BitSet(new long[]{0x00000040C6CC08A0L});
    public static final BitSet FOLLOW_function_in_module2483 = new BitSet(new long[]{0x00000040C6CC08A0L});
    public static final BitSet FOLLOW_statement_in_module2494 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_EOL_in_module2518 = new BitSet(new long[]{0x00000040C6CC08A0L});
    public static final BitSet FOLLOW_EOF_in_module2556 = new BitSet(new long[]{0x0000000000000002L});

}