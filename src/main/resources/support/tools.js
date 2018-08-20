var timeStampVm;

$(document).ready(function(){
    timeStampVm = new Vue({
        el:'#select_div',
        data:{
            items:[
                {text:"A",value:"a"},
                {text:"B",value:"b"},
            ],
            message: '123',
            selected:'',
            result:'',
        },
        methods : {
            /** 点击查询 */
            nowTimeStamp : function() {
                this.searchNowStamp();
            },

            /** 查询方法 */
            searchNowStamp : function() {
                var self = this;
                $.ajax({
                    type : 'GET',
                    url : "http://localhost:8080/tools/nowTimeStamp/"+selected,
                }).done(function(response) {
                    debugger;
                    if (response.success){
                        self.result = response.obj;
                    }
                });
            },

        }
    });

})