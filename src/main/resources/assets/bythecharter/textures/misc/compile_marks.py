import Image
import os
import glob

path = os.path.dirname(os.path.realpath(__file__))

for file in os.listdir(path):
    if file.endswith(".png"):
        os.remove(os.path.join(path,file))

partPath = path+"/parts/"
parts_bg = glob.glob(partPath+"bg_*.png")
parts_fg = glob.glob(partPath+"fg_*.png")
parts_in = glob.glob(partPath+"in_*.png")
parts_out = glob.glob(partPath+"out_*.png")

#Used to track how many marks have been created
marksMade = 0

#Iterate through all the backgrounds, as every mark is based on a background
for bg_file in parts_bg:
    bg = Image.open(bg_file)

    #Simplest type of mark is bg + fg, so we get all of those done first
    for fg_file in parts_fg:
        fg = Image.open(fg_file)
        marksMade += 1
        Image.alpha_composite(bg,fg).save("mark" + str(marksMade) + ".png")

    #Marks can be bg + in with nothing else, these are done here
    for in_file in parts_in:
        inn = Image.open(in_file)
        marksMade += 1
        Image.alpha_composite(bg,inn).save("mark" + str(marksMade) + ".png")

    #Marks can be bg + out with nothing else, these are done here
    for out_file in parts_out:
        out = Image.open(out_file)
        marksMade += 1
        Image.alpha_composite(bg,out).save("mark" + str(marksMade) + ".png")

    #Build all of the combinations of inner and outer parts for this bg
    for in_file in parts_in:
        inn = Image.open(in_file)
        bg_in = Image.alpha_composite(bg,inn)
        for out_file in parts_out:
            out = Image.open(out_file)
            marksMade += 1
            Image.alpha_composite(bg_in, out).save("mark" + str(marksMade) +".png")
