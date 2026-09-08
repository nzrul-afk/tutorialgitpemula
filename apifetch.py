import requests
import json

def get_joke():
    res = requests.get('https://v2.jokeapi.dev/joke/Any')
    data = res.json()
    if data['type'] == 'twopart':
        return f"{data['setup']}\n{data['delivery']}"
    else:
        return data['joke']
def get_fact():
    res = requests.get('https://catfact.ninja/fact')
    data = res.json()
    return data['fact']

def load_json():
    try:
        with open('apifetch.json', 'r') as f:
            return json.load(f)
    except FileNotFoundError:
        return []
    
def save_json(data):
    with open('apifetch.json', 'w') as f:
        json.dump(data, f)

data= load_json()

fitur= ('JOKES','CAT FACT','SIMPANAN', 'EXIT')


while True:
    print('======GENERATE JOKE AND CAT FACT======')
    for index, f in enumerate(fitur, 1):
        print(index, f)
    pilihan= input('masukan angka untuk memilih ')
    if pilihan == '1':
        while True:
            joke= get_joke()
            print(joke)
            simpan = input('simpan ga (y/n)')
            if simpan == "y":
                data.append({"joke": joke})
                save_json(data)
                print('joke berhasil disimpan')
            pilihan1 = input('lagi? (y/n)')
            if pilihan1 == 'n':
                break
            else:
                print('ngawur')
    if pilihan == '2':
        while True:
            fact_cat=get_fact()
            print(fact_cat)
            simpan = input('simpan ga (y/n)')
            if simpan == 'y':
                data.append({"fact": fact_cat})
                save_json(data)
                print('berhasil disimpan')
            pilihan2 = input('lagi (y/n)')
            if pilihan2 == 'n':
                break
    if pilihan == '3':
        while True:
            simpenan = load_json()
            print('JOKE')
            for index, s in enumerate(simpenan):
                save_json(data)
                if 'joke' in s:
                    print (index,s['joke'])
                else:
                    print (index,'[CAT FACT]' ,s['fact'])


            pilihan3= input('keluar (y/n)')
            if pilihan3 == 'y':
                break
            else:
                print('ngawur')
    if pilihan == '4':
        print('terimakasih')
        break
    else:
        print('masukan yang baik dan benar')


