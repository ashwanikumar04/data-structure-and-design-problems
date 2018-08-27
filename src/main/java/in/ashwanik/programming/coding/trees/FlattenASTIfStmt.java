package in.ashwanik.programming.coding.trees;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.*;

public class FlattenASTIfStmt {

    public static String classText = "public class FlattenASTIfStmtData {\n" +
            "\n" +
            "    public void test(int a) {\n" +
            "        if (a > 10 || a < 15) {\n" +
            "\n" +
            "        }\n" +
            "        if (a < 20) {\n" +
            "\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "}";

    public static void main(String[] args) {
        FlattenASTIfStmt flattenASTIfStmt = new FlattenASTIfStmt();
        flattenASTIfStmt.getFlattenedIfElse(classText);
    }

    public List<Statement> getFlattenedIfElse(String text) {
        CompilationUnit compilationUnit = JavaParser.parse(text);
        List<Statement> ifStmts = new ArrayList<>();
        compilationUnit.accept(new MethodVisitor(ifStmts), null);
        List<Statement> flatList = new ArrayList<>();
        for (Statement statement : ifStmts) {
            IfStmt ifStmt = statement.asIfStmt();
            List<Statement> list = new ArrayList<>();
            process(ifStmt, list);
            if (list.isEmpty()) {
                list.add(ifStmt);
            }
            flatList.addAll(list);
        }
        return flatList;
    }

    private void process(IfStmt ifStmt, List<Statement> statements) {
        Deque<BinaryExpr> queue = new ArrayDeque<>();
        if (ifStmt.getCondition().isBinaryExpr()) {
            queue.add(ifStmt.getCondition().asBinaryExpr());
        }
        while (!queue.isEmpty()) {
            BinaryExpr binaryExpr = queue.remove();
            BinaryExpr.Operator operator = binaryExpr.getOperator();
            boolean isOr = (operator) == BinaryExpr.Operator.OR;
            if (isOr) {
                processBinaryExpression(binaryExpr, statements, ifStmt, queue);
            }
        }
    }

    private static void processBinaryExpression(BinaryExpr binaryExpr,
                                                List<Statement> statements,
                                                IfStmt ifStmt,
                                                Deque<BinaryExpr> queue) {
        Expression left = binaryExpr.getLeft();
        Expression right = binaryExpr.getRight();
        if (left.isBinaryExpr()) {
            BinaryExpr leftExpr = binaryExpr.getLeft().asBinaryExpr();
            addToStatementsListAndCreateNewBinaryExpression(statements, leftExpr, ifStmt, queue);
        }
        if (right.isBinaryExpr()) {
            BinaryExpr rightExpr = binaryExpr.getRight().asBinaryExpr();
            addToStatementsListAndCreateNewBinaryExpression(statements, rightExpr, ifStmt, queue);
        }
        if (left.isEnclosedExpr()) {
            flattenEnclosedExpression(queue, left);
        }
        if (right.isEnclosedExpr()) {
            flattenEnclosedExpression(queue, right);
        }
    }

    private static void addToStatementsListAndCreateNewBinaryExpression(List<Statement> statements,
                                                                        BinaryExpr binaryExpr,
                                                                        IfStmt ifStmt,
                                                                        Deque<BinaryExpr> queue) {
        statements.add(new IfStmt(binaryExpr, ifStmt.getThenStmt(), null));
        queue.add(new BinaryExpr(binaryExpr.getLeft(), binaryExpr.getRight(), binaryExpr.getOperator()));
    }

    private static void flattenEnclosedExpression(Deque<BinaryExpr> queue,
                                                  Expression enclosedExpr) {

        if (enclosedExpr.isEnclosedExpr()) {
            flattenEnclosedExpression(queue, enclosedExpr.asEnclosedExpr().getInner());
        } else if (enclosedExpr.isBinaryExpr()) {
            queue.add(enclosedExpr.asBinaryExpr());
        }
    }

    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        List<Statement> statements;

        public MethodVisitor(List<Statement> statements) {
            super();
            this.statements = statements;
        }

        @Override
        public void visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
            Optional<BlockStmt> body = n.getBody();
            if (body.isPresent()) {
                for (Statement statement : body.get().getStatements()) {
                    if (statement.isIfStmt()) {
                        this.statements.add(statement);
                    }
                }
            }
        }
    }
}
