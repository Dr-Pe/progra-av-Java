esPar :: Int -> Bool
esPar n =
  if rem n 2 == 0 then True
  else False

contarPares :: [Int] -> Int
contarPares [] = 0 
contarPares (x:xs) = 
  if esPar x then contarPares xs + 1 
  else contarPares xs

main =
  print (contarPares [1, 2, 3, 4, 5, 6, 6])