// Интерфейс выражений
interface Expression {
    boolean interpret();
}

// Терминальное выражение (логическое значение)
class BooleanValue implements Expression {
    private final boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean interpret() {
        return value;
    }
}

// Нетерминальное выражение (AND)
class AndExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public AndExpression(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public boolean interpret() {
        return leftExpression.interpret() && rightExpression.interpret();
    }
}

// Нетерминальное выражение (OR)
class OrExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public OrExpression(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public boolean interpret() {
        return leftExpression.interpret() || rightExpression.interpret();
    }
}

// Нетерминальное выражение (NOT)
class NotExpression implements Expression {
    private final Expression expression;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret() {
        return !expression.interpret();
    }
}

// Демонстрация использования
public class InterpreterPatternLogicalExample {
    public static void main(String[] args) {
        // Создаем логическое выражение для (true AND false) OR NOT false
        Expression expressionAnd = new AndExpression(new BooleanValue(true), new BooleanValue(false)); // false
        Expression expressionNot = new NotExpression(new BooleanValue(false)); // true
        Expression expressionOr = new OrExpression(expressionAnd, expressionNot); // false OR true = true

        // Интерпретируем выражение
        boolean finalExpression = expressionOr.interpret();
        System.out.println("Result: " + finalExpression); // Вывод: Result: true
    }
}
