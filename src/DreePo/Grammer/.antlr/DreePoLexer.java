// Generated from c:\Users\ruiar\Desktop\Projects\DreePoLanguage\src\DreePo\Grammer\DreePoLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DreePoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHILE=1, BOOL=2, IDENTIFIER=3, BOOL_OPERATOR=4, INTEGER=5, FLOAT=6, STRING=7, 
		NULL=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHILE", "BOOL", "IDENTIFIER", "BOOL_OPERATOR", "INTEGER", "FLOAT", "STRING", 
			"NULL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "BOOL", "IDENTIFIER", "BOOL_OPERATOR", "INTEGER", "FLOAT", 
			"STRING", "NULL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DreePoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DreePoLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nb\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2\36\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3)\n\3\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5:\n\5\3\6\6\6=\n\6\r\6\16\6>\3\7\6\7B\n\7\r\7\16\7C\3\7\3"+
		"\7\6\7H\n\7\r\7\16\7I\3\b\3\b\7\bN\n\b\f\b\16\bQ\13\b\3\b\3\b\3\b\7\b"+
		"V\n\b\f\b\16\bY\13\b\3\b\5\b\\\n\b\3\t\3\t\3\t\3\t\3\t\2\2\n\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\3\2"+
		"$$\3\2))\2l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\35\3\2\2\2\5(\3\2\2\2\7*\3"+
		"\2\2\2\t9\3\2\2\2\13<\3\2\2\2\rA\3\2\2\2\17[\3\2\2\2\21]\3\2\2\2\23\24"+
		"\7y\2\2\24\25\7j\2\2\25\26\7k\2\2\26\27\7n\2\2\27\36\7g\2\2\30\31\7w\2"+
		"\2\31\32\7p\2\2\32\33\7v\2\2\33\34\7k\2\2\34\36\7n\2\2\35\23\3\2\2\2\35"+
		"\30\3\2\2\2\36\4\3\2\2\2\37 \7v\2\2 !\7t\2\2!\"\7w\2\2\")\7g\2\2#$\7h"+
		"\2\2$%\7c\2\2%&\7n\2\2&\'\7u\2\2\')\7g\2\2(\37\3\2\2\2(#\3\2\2\2)\6\3"+
		"\2\2\2*.\t\2\2\2+-\t\3\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/"+
		"\b\3\2\2\2\60.\3\2\2\2\61\62\7c\2\2\62\63\7p\2\2\63:\7f\2\2\64\65\7q\2"+
		"\2\65:\7t\2\2\66\67\7z\2\2\678\7q\2\28:\7t\2\29\61\3\2\2\29\64\3\2\2\2"+
		"9\66\3\2\2\2:\n\3\2\2\2;=\t\4\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2"+
		"\2\2?\f\3\2\2\2@B\t\4\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3"+
		"\2\2\2EG\7\60\2\2FH\t\4\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\16"+
		"\3\2\2\2KO\7$\2\2LN\n\5\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR"+
		"\3\2\2\2QO\3\2\2\2R\\\7$\2\2SW\7)\2\2TV\n\6\2\2UT\3\2\2\2VY\3\2\2\2WU"+
		"\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z\\\7)\2\2[K\3\2\2\2[S\3\2\2\2\\"+
		"\20\3\2\2\2]^\7p\2\2^_\7w\2\2_`\7n\2\2`a\7n\2\2a\22\3\2\2\2\r\2\35(.9"+
		">CIOW[\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}