eulers(0,1,1,10000)


function answer = eulers(start_point, end_point, initial_value ...
    ,number_of_itterations)

t = start_point;
y = initial_value;
h = end_point/number_of_itterations;

for i = 1:number_of_itterations
    
    y = y + h*f(t,y);
    t = t + h;
    
end %for

answer = y;
end %Eulers

function answer = f(x, y)

answer = y*cos(y);

end