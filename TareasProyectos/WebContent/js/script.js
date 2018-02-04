$(".borrar-tarea").click(function(evnt) {
	evnt.preventDefault();

	var tidval = this.getAttribute("data-tid");
	var elem=this;
	
	$.post('./tareas/borrar',{tid:tidval},function(json){
		if(json.data){$(elem).closest(".list-group-item").remove();};
	},'json').fail(function(error) {
		console.log("error:",error);
	});
	
});