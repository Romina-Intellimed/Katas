var empty_object = {};
var stooge = {
    "first-name": "Jerome",
    "last-name": "Howard"
};


var flight = {
    airline: "Oceanic",
    number: 815,
    departure: {
        IATA: "SYD",
        time: "2004-09-22 14:55",
        city: "Sydney"
    },
    arrival: {
        IATA: "LAX",
        time: "2004-09-23 10:42",
        city: "Los Angeles"
    }
};


stooge["first-name"]
flight.departure.IATA

stooge['first-name'] = 'Jerome';
//added along
stooge['middle-name'] = 'Lester';
stooge.nickname = 'Curly';
flight.equipment = {
    model: 'Boeing 777'
};
flight.status = 'overdue'

//reference

var x = stooge;
x.nickname = 'Curly';
var nick = stooge.nickname;
// nick is 'Curly' because x and stooge
// are references to the same object
var a = {}, b = {}, c = {};
// a, b, and c each refer to a
// different empty object
a = b = c = {};
// a, b, and c all refer to
// the same empty object

if (typeof Object.create !== 'function') {
    Object.create = function (o) {
        var F = function () {
        };
        F.prototype = o;
        return new F();
    };
}

var another_stooge = Object.create(stooge);

another_stooge['first-name'] = 'Harry';
another_stooge['middle-name'] = 'Moses';
another_stooge.nickname = 'Moe';

stooge.profession = 'actor';
another_stooge.profession  //actor

typeof flight.number //number
typeof flight.status //string
typeof flight.arrival //object
typeof flight.manifest //undefined

typeof flight.toString // 'function'


flight.hasOwnProperty('number')  //true
flight.hasOwnProperty('constructor') //false

var name;
for (name in another_stooge) {
    if (typeof another_stooge[name] !== 'function') {
        document.writeln(name + ': ' + another_stooge[name]);
    }
}

var i;
var properties = [
    'first-name',
    'middle-name',
    'last-name',
    'profession'
];
for (i = 0; i < properties.length; i += 1) {
    document.writeln(properties[i] + ': ' +
        another_stooge[properties[i]]);
}


var myObject = {
    value: 0,
    increment: function(inc) {
        this.value += typeof inc === 'number' ? inc : 1;
    }

};
myObject.increment();
document.writeln(myObject.value);

myObject.increment(2);
document.writeln(myObject.value);

myObject.double=function(){
    var that=this;

    var helper=function(){
        that.value=add(that.value,that.value);
    };
    helper();
};

myObject.double();
document.writeln(myObject.getValue());

var Quo=function(string){
    this.status=string;
};

Quo.prototype.get_status=function(){
    return this.status;
}

var myQuo=new Quo("confused");
document.writeln(myQuo.get_status());


var array=[3,40];
var sum=add.apply(null,array);

var statusObject={
    status:'A-OK'
}

var status=Quo.prototype.get_status().apply(statusObject);

var sum=function(){
    var i,sum=0;
    for(i=0;i<arguments.length;i++){
        sum+=arguments[i];
    }
    return sum;
}

document.writeln(sum(4,8,9,5,14,6));

