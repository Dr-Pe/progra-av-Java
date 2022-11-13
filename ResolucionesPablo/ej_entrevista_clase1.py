def show_grouped(arr):
    for i in range(len(arr)-1):
        for j in range(len(arr)-i):
            for z in range(j, i+j+1):
                print(arr[z], end='')
            print('')

arr = [1,2,3,4,5]
show_grouped(arr)