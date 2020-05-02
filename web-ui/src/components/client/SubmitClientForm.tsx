import React from 'react';
import Button from '@material-ui/core/Button';

import global_data from '../../store/global_data';

function SubmitClientForm() {
  const onClick = (event: any) => {
    global_data.createClients(() => global_data.readClients(
      () => global_data.updateControlPanel()
    ));
  };

  return (
    <div>
      <Button variant="contained" color="primary" onClick={onClick}>
        Submit
      </Button>
    </div>
  );
}

export default SubmitClientForm;
