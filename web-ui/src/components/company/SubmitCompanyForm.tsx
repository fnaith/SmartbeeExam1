import React from 'react';
import Button from '@material-ui/core/Button';

import global_data from '../../store/global_data';

function SubmitCompanyForm() {
  const onClick = (event: any) => {
    global_data.createCompanies(() => global_data.readCompanies(
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

export default SubmitCompanyForm;
