import React from 'react';
import Button from '@material-ui/core/Button';

import global_data from '../../store/global_data';

import ClientFormCompanyId from './ClientFormCompanyId';
import ClientFormName from './ClientFormName';
import ClientFormEmail from './ClientFormEmail';
import ClientFormPhone from './ClientFormPhone';

interface Props {
  index: number;
}

function ClientForm(props: Props) {
  const { index } = props;

  const onClick = (event: any) => {
    global_data.removeClientForm(index);
    global_data.updateControlPanel();
  };

  return (
    <div>
      <ClientFormCompanyId index={index} />
      <ClientFormName index={index} />
      <ClientFormEmail index={index} />
      <ClientFormPhone index={index} />
      <Button variant="contained" color="primary" onClick={onClick}>
        Remove
      </Button>
    </div>
  );
}

export default ClientForm;
