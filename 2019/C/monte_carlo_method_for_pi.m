% Monty carlo method to find pi

monte_carlo_method_for(10000000)

function answer = monte_carlo_method_for(how_accurate)
itterator = 0;
successes = 0;

while (itterator < how_accurate)
    x = rand();
    y = rand();
    
    if (x^2 + y^2 <= 1)
       successes = successes + 1; 
    end
    
    itterator = itterator + 1;
    
end

answer = successes / how_accurate; 

%must times by four because of four quadrents
answer = answer * 4;

end