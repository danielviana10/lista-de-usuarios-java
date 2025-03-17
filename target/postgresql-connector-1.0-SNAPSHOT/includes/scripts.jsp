<script>
    document.addEventListener('DOMContentLoaded', function () {
        document.body.addEventListener('click', function (event) {
            const button = event.target.closest('.delete-button'); 
            if (button) {
                let personId = button.getAttribute('data-id').trim();
                const confirmDeleteButton = document.getElementById('confirmDeleteButton');
                if (confirmDeleteButton) {
                    confirmDeleteButton.href = "deletePerson?id=" + encodeURIComponent(personId);
                    console.log("URL de exclusão atualizada para:", confirmDeleteButton.href);
                }
            }
        });

        // Edição
        const editButtons = document.querySelectorAll('.edit-button');
        editButtons.forEach(button => {
            button.addEventListener('click', function () {
                const personId = this.getAttribute('data-id').trim();
                const personName = this.getAttribute('data-name').trim();
                const personEmail = this.getAttribute('data-email').trim();

                document.getElementById('editPersonId').value = personId;
                document.getElementById('editName').value = personName;
                document.getElementById('editEmail').value = personEmail;
            });
        });
    });
</script>
