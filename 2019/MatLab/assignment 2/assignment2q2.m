syms a b c h;

function1 = a + b + c;
function2 = h*(b + 2*c) - 1;
function3 = b + 4*c;

sol = solve([function1, function2, function3], [a,b,c]);
aSol = sol.a
bSol = sol.b
cSol = sol.c