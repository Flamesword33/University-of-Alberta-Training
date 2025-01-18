% Final_exam_340.m
%
% by Nathan Pelletier
% submitted: April 27 2019
% AUCSC/MAT/PHY 340

newtons_method(5,5)
newtons_method(-5,5)
newtons_method(5,-5)
newtons_method(-5,-5)


% newtons_method(int,int) --> matix[int, int]
%
% preforms a 2-D newtons method on any x and y variable
% requires function f(x,y), g(x,y)
% requires partial derivitive functions
% df_dx(x,y) df_dy(x,y)
% dg_dx(x,y) dg_dy(x,y)
function answer = newtons_method(x,y)

for i = 1:100
   J = [df_dx(x,y) df_dy(x,y); dg_dx(x,y) dg_dy(x,y)];
   A = [f(x,y) ; g(x,y)];
   
   J2 = J\A;
   
   x = x - J2(1);
   y = y - J2(2);
    
end %for
z = [x ; y];
answer = z;

end %newtons_method


function answer = f(x,y)
answer = x^2 + y^2 - 4;
end %f

function answer = g(x,y)
b = 22^2;
answer = x^2 + (y^2/b) - 1;
end %g

function answer = df_dx(x,y)
answer = 2*x;
end %df_dx

function answer = df_dy(x,y)
answer = 2*y;
end %df_dy

function answer = dg_dx(x,y)
answer = 2*x;
end %dg_dx

function answer = dg_dy(x,y)
b = 22^2;
answer = 2*(y/b);
end %dg_dy

%TWO QUESTIONS AT END OF QUESTION 6
% a) Why is it enough to find only one intersection?
%   Because we are working with a circle and a elipse we know that if they
%   intersect they contain symetry. Therefore, if we know one answer then
%   we simply multiply either x or y or both by -1 to get our other answers
%
% b) How do we get the other ones?
%   If we wish to get other answers with Newtons method then we must choose
%   different values for x and y as our innitial guesses. 
%   Newtons method only finds the closest intesect to the values given