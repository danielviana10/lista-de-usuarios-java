<div class="modal fade" id="editPersonModal" tabindex="-1" aria-labelledby="editPersonModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editPersonModalLabel">Editar Pessoa</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editPersonForm" action="updatePerson" method="post">
                    <input type="hidden" id="editPersonId" name="id">
                    <div class="mb-3">
                        <label for="editName" class="form-label">Nome:</label>
                        <input type="text" id="editName" name="name" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="editEmail" class="form-label">Email:</label>
                        <input type="email" id="editEmail" name="email" class="form-control" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="submit" form="editPersonForm" class="btn btn-primary">Salvar</button>
            </div>
        </div>
    </div>
</div>