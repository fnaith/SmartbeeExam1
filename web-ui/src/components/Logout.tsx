import React from 'react';
import Button from '@material-ui/core/Button';

import global_data from '../store/global_data';

function SubmitCompanyForm() {
  const onClick = (event: any) => {
    global_data.logout();
  };

  return (
    <div>
      <Button variant="contained" color="primary" onClick={onClick}>
        Logout
      </Button>
    </div>
  );
}

export default SubmitCompanyForm;
