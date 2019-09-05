韩老师的Caculator的bug:
不能连着减(要用while而不是if)

我的Caculator写的顺序:
1. CaculatorInfix:直接计算中缀表达式的四则运算
2. CaculatorInfixPro:在上基础上增加括号和指数支持(韩老师的练习)
3. CaculatorSuffix:直接计算后缀表达式
4. Caculator:将中缀变为后缀并计算
5. CaculatorPro:增加浮点数支持,返回浮点数