x1 = 0.85;
x2 = 0.05;

for i = 1:17
    
    J = [1/(1-x1-x2) -1/x1 ; 1/(1-x1-x2) -1/x2];
    A = [-log(1-x1-x2)-log(x1)-log(x2) ; -log(1-x1-x2)-log(x1)-log(x2)];
    
    J2 = -J\A;
    
    x1 = x1 - J2(1);
    x2 = x2 - J2(2);
end

x1
x2
A(1)^2 + A(2) ^2