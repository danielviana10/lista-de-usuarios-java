<script>
    const deleteButtons = document.querySelectorAll('.delete-button');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function () {
            const personId = this.getAttribute('data-id');
            const confirmDeleteButton = document.getElementById('confirmDeleteButton');
            confirmDeleteButton.href = `deletePerson?id=${personId}`;
        });
    });

    const editButtons = document.querySelectorAll('.edit-button');
    editButtons.forEach(button => {
        button.addEventListener('click', function () {
            const personId = this.getAttribute('data-id');
            const personName = this.getAttribute('data-name');
            const personEmail = this.getAttribute('data-email');

            document.getElementById('editPersonId').value = personId;
            document.getElementById('editName').value = personName;
            document.getElementById('editEmail').value = personEmail;
        });
    });
</script>