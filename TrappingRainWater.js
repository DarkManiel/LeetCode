/**
 * Created by markdaniel on 8/30/15.
 */
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height.length < 2) { return 0;}
    var waters = [];
    for (var i = 0; i < height.length; i ++) {
        waters.push(0);
    }

    var heightCount = height.length;
    var index = heightCount - 1;
    var sum = 0;
    var max = 0;
    while (index >= 0) {
        var curHeight = height[index];
        max = Math.max(max, curHeight);
        while (index > 0 && curHeight > height[index - 1]) {
            waters[index - 1] = curHeight - height[index - 1];
            max = Math.max(max, height[index - 1]);
            index --;
        }
        index --;
    }

    index = 0;
    while (index < height.length) {
        curHeight = height[index];
        var nextHeight = height[index + 1];
        var hasDitch = false;
        if (index < height.length - 1 && curHeight > height[index + 1]) {waters[index] = 0;}
        while (index < height.length - 1 && curHeight > height[index + 1]) {
            hasDitch = true;
            nextHeight = height[index + 1];
            waters[index + 1] = Math.min(waters[index + 1], curHeight - nextHeight);
            index ++;
        }
        if (! hasDitch) {
            waters[index] = 0;
        }
        index ++;
    }

    for (i = 0; i < waters.length; i ++) {
        sum += waters[i];
    }
    return parseInt(sum);
};

var height = [5,5,1,7,1,1,5,2,7,6];

console.log(trap(height));