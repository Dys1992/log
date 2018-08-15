var listVm;

$(document).ready(function() {
    listVm = new Vue({
        el : '#list',
        data : {
            // 结果对象
            resultList:[],
            logForm:{}
        },
        created:function(){
            this.query()
        },
        methods : {
            /** 点击查询 */
            search : function() {
                this.query();
            },

            /** 查询方法 */
            query : function() {
                debugger;
                var self = this;
                $.ajax({
                    type : 'POST',
                    url : "http://localhost:8080/ymm-info-log/loglist",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(self.logForm),
                }).done(function(response) {
                    debugger;
                    if (response.code == 0){
                        self.resultList = response.result;
                    }
                });
            },

        }
    });
});