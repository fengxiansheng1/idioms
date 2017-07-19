$(function () {
    $("#jqGrid").jqGrid({
        url: '../sysidioms/list',
        datatype: "json",
        colModel: [			
			{ label: '成语编号', name: 'idiomsId', width: 50, key: true },
			{ label: '成语的名称', name: 'name', width: 80 }, 			
			{ label: '成语的解释', name: 'description', width: 80 }, 			
			{ label: '成语类型', name: 'type', width: 80,formatter: function(value, options, row){
				if(value === 3){
					return '<span class="label label-primary">三字成语</span>';
				}
				if(value === 4){
					return '<span class="label label-success">四字成语</span>';
				}
				if(value === 5){
					return '<span class="label label-warning">五字成语</span>';
				}
				if(value === 6){
					return '<span class="label label-warning">六字成语</span>';
				}
				if(value === 7){
					return '<span class="label label-warning">七字成语</span>';
				}
				if(value === 8){
					return '<span class="label label-warning">八字成语</span>';
				}
				if(value === 9){
					return '<span class="label label-warning">九字成语</span>';
				}
				if(value === 10){
					return '<span class="label label-warning">十字成语</span>';
				}
				if(value === 11){
					return '<span class="label label-warning">十一字成语</span>';
				}
				
				} }, 			
			{ label: '状态', name: 'isDeleted', width: 80,formatter: function(value, options, row){
				return value === 1 ? 
						'<span class="label label-danger">禁用</span>' : 
						'<span class="label label-success">正常</span>';
				} }, 			
		/*	{ label: '创建人', name: 'createUserId', width: 80 }, 	*/		
			{ label: '创建时间', name: 'createTime', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		sysIdioms: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysIdioms = {};
		},
		update: function (event) {
			var idiomsId = getSelectedRow();
			if(idiomsId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(idiomsId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysIdioms.idiomsId == null ? "../sysidioms/save" : "../sysidioms/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.sysIdioms),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var idiomsIds = getSelectedRows();
			if(idiomsIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sysidioms/delete",
				    data: JSON.stringify(idiomsIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(idiomsId){
			$.get("../sysidioms/info/"+idiomsId, function(r){
                vm.sysIdioms = r.sysIdioms;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});