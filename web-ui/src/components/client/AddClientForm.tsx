import React from 'react';
import Button from '@material-ui/core/Button';

import global_data from '../../store/global_data';

function AddClientForm() {
  const onClick = (event: any) => {
    global_data.addClientForm();
    global_data.updateControlPanel()
  };

  return (
    <div>
      <Button variant="contained" color="primary" onClick={onClick}>
        Add
      </Button>
    </div>
  );
}

export default AddClientForm;
