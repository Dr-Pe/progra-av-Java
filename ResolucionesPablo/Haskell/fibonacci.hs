fib :: Int -> Int
fib 1 = 1
fib 2 = 1
fib n = 
  if n > 2 
    then fib (n - 1) + fib (n - 2)
  else -1 -- Error

main = print (fib 8)